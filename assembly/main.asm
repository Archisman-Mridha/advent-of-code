BITS 64

%define EXIT_SYSCALL_CODE 60

global _start
section .text
_start:

    mov rax, EXIT_SYSCALL_CODE
    mov rdi, 69
    syscall