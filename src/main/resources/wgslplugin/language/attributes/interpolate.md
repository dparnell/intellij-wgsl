```wgsl
@interpolate(a, b)
```

interpolate	One or two parameters.
The first parameter must be an interpolation type. The second parameter, if present, must specify the interpolation sampling.

Must only be applied to a declaration that is decorated with a location attribute.
Specifies how the user-defined IO must be interpolated. The attribute is only significant on user-defined vertex outputs and fragment inputs.