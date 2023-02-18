# 1

```asm
section _text
```

`section .text` is a directive that specifies a section of code that contains the actual executable instructions for a program.

# 2

```asm
demoStringBuffer:
        db "welcome to x86_64 assembly", 10
    demoStringBufferSize:
        dq $-demoStringBuffer
```

The `$` symbol in assembly code represents the current address of the program counter. When used with the - operator, it represents the difference between the current address and the address of the **demoStringBuffer** label.

So, $-demoStringBuffer calculates the number of bytes between the current address and the beginning of the demoStringBuffer label. Since the demoStringBuffer string is defined using the "db" directive, which stores each character as a single byte, the result of this calculation is the size of the string in bytes.

The result of this calculation is then stored in a 64-bit integer named demoStringBufferSize using the "dq" directive. This allows the program to reference the size of the string later on, using the label demoStringBufferSize.