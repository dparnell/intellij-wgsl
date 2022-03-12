```wgsl
@workgroup_size(x, y, z)
```

One, two or three parameters.
Each parameter is either a literal or module-scope constant. All parameters must be of the same type, either i32 or u32.

Must be applied to a compute shader entry point function. Must not be applied to any other object.
Specifies the x, y, and z dimensions of the workgroup grid for the compute shader.

The first parameter specifies the x dimension. The second parameter, if provided, specifies the y dimension, otherwise is assumed to be 1. The third parameter, if provided, specifies the z dimension, otherwise is assumed to be 1. Each dimension must be at least 1 and at most an upper bound specified by the WebGPU API.