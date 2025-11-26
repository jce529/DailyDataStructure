using UnityEngine;
using UnityEngine.InputSystem;
using System;

public class InputHandler : MonoBehaviour
{
    // --- 싱글톤 (어디서든 접근 가능) ---
    public static InputHandler Instance { get; private set; }

    [Header("Input Settings")]
    public InputActionAsset inputActions; // Unity 에디터에서 만든 .inputactions 파일 연결

    // --- 이벤트 정의 (외부 스크립트가 구독할 대상) ---
    public event Action<Vector2> OnMoveEvent;   // 이동 (Vector2 반환)
    public event Action OnJumpEvent;            // 점프 (버튼)
    public event ActionOnPauseEvent;            // 일시정지 (버튼)
    public event Action<bool> OnRunEvent;       // 달리기 (누르고 있는지 여부)

    // 내부 관리 변수
    private InputAction moveAction;
    private InputAction jumpAction;
    private InputAction pauseAction;
    private InputAction runAction;

    private void Awake()
    {
        // 싱글톤 초기화
        if (Instance == null) { Instance = this; DontDestroyOnLoad(gameObject); }
        else { Destroy(gameObject); return; }

        // 1. 액션 초기화 (Asset에서 찾기)
        var playerMap = inputActions.FindActionMap("Player"); // "Player"는 액션 맵 이름
        moveAction = playerMap.FindAction("Move");
        jumpAction = playerMap.FindAction("Jump");
        pauseAction = playerMap.FindAction("Pause");
        runAction = playerMap.FindAction("Run");

        // 2. 세이브된 키 바인딩 로드 (있다면 적용)
        LoadBindingOverrides();

        // 3. 입력 감지 시 이벤트 연결
        RegisterInputEvents();
    }

    private void OnEnable()
    {
        inputActions.Enable(); // 입력 활성화
    }

    private void OnDisable()
    {
        inputActions.Disable(); // 입력 비활성화
    }

    // --- 핵심: 입력 감지 및 이벤트 전파 ---
    private void RegisterInputEvents()
    {
        // 이동: 값이 변할 때마다 Vector2 전달
        moveAction.performed += ctx => OnMoveEvent?.Invoke(ctx.ReadValue<Vector2>());
        moveAction.canceled += ctx => OnMoveEvent?.Invoke(Vector2.zero);

        // 점프: 눌렀을 때만 발동
        jumpAction.performed += ctx => OnJumpEvent?.Invoke();

        // 일시정지: 눌렀을 때만 발동
        pauseAction.performed += ctx => OnPauseEvent?.Invoke();

        // 달리기: 누름(true) / 뗌(false) 전달
        runAction.performed += ctx => OnRunEvent?.Invoke(true);
        runAction.canceled += ctx => OnRunEvent?.Invoke(false);
    }

    // --- 키 바인딩 저장 및 로드 (User Custom Key) ---
    
    // 키 설정을 저장 (JSON 포맷)
    public void SaveBindingOverrides()
    {
        string rebinds = inputActions.SaveBindingOverridesAsJson();
        PlayerPrefs.SetString("InputBindings", rebinds);
        PlayerPrefs.Save();
    }

    // 저장된 키 설정 불러오기
    public void LoadBindingOverrides()
    {
        string rebinds = PlayerPrefs.GetString("InputBindings");
        if (!string.IsNullOrEmpty(rebinds))
        {
            inputActions.LoadBindingOverridesFromJson(rebinds);
        }
    }
}
