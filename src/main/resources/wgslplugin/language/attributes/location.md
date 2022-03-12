```wgsl
@location(i32)
```

Must only be applied to an entry point function parameter, entry point return type, or member of a structure type. Must only be applied to declarations of numeric scalar or numeric vector type. Must not be used with the compute shader stage.
Specifies a part of the user-defined IO of an entry point.