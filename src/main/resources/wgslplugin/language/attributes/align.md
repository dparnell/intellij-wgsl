```wgsl
@align(i32)
```

Must only be applied to a member of a structure type.
Must be a power of 2, and must satisfy the required-alignment for the member type:

If align(n) is applied to a member of S with type T, and S is the store type or contained in the store type for a variable in address space C, then n must satisfy: n = k × RequiredAlignOf(T,C) for some positive integer k.
