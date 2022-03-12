```wgsl
size(i32)
```

Must only be applied to a member of a structure type.
The number of bytes reserved in the struct for this member.

This number must be at least the byte-size of the type of the member:

If size(n) is applied to a member with type T, then SizeOf(T) ≤ n.