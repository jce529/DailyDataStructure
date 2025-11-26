using System;
using UnityEngine;
using UnityEngine.InputSystem;

public class InputHandler : MonoBehaviour
{
    //1. 싱글톤 인스턴스
    public static InputHandler Instance { get; private set; }

    //2. 입력 이벤트 정의
    public event Action<Vector2> OnMoveInput;
    public event Action OnJumpPerformed;
    public event Action OnDashPressed;
    public event Action OnRunPressed;
    public event Action OnRunReleased;
    public event Action OnPausePressed;

    // 3. 입력 시스템 참조 및 키 값 저장
    private PlayerInput playerInput;

    [Header("Input Bindings (Default/Save)")]
    //키 할당 정보를 표시하거나 로드
    // 실제 키 값은 PlayerInput Asset에 저장되어 있지만, 여기서는 UI 표시를 위한 변수만 둡니다.
}
