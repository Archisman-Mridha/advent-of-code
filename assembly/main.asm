BITS 64

%define EXIT_SYSCALL_CODE 60
%define WRITE_SYSCALL_CODE 1

section .data
    demoStringBuffer:
        db "welcome to x86_64 assembly", 10
    demoStringBufferSize:
        dq $-demoStringBuffer

section .text
global _start
    _start:

        mov rax, WRITE_SYSCALL_CODE
        mov rdi, 1
        mov rsi, demoStringBuffer
        mov rdx, [demoStringBufferSize]
        syscall

        mov rax, EXIT_SYSCALL_CODE
        mov rdi, 0
        syscall