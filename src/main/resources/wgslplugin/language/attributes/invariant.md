```wgsl
@invariant
```

Must only be applied to the position built-in value.
When applied to the position built-in output value of a vertex shader, the computation of the result is invariant across different programs and different invocations of the same entry point. That is, if the data and control flow match for two position outputs in different entry points, then the result values are guaranteed to be the same. There is no affect on a position built-in input value.

Note: this attribute maps to the precise qualifier in HLSL, and the invariant qualifier in GLSL.