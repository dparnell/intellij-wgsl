
// numeric functions

/**
Returns the absolute value of e (e.g. e with a positive sign bit). Component-wise when T is a vector. (GLSLstd450Fabs)

* T is `i32`, `f32`, `u32`, `vecN<i32>`, `vecN<f32>` or `vecN<u32>`
*/
fn abs(e: T) -> T {}

/**
Returns the arc cosine of e. Component-wise when T is a vector. (GLSLstd450Acos)

* T is `f32` or `vecN<f32>`
*/
fn acos(e: T) -> T {}

/**
Returns the arc sine of e. Component-wise when T is a vector. (GLSLstd450Asin)

* T is `f32` or `vecN<f32>`
*/
fn asin(e: T) -> T {}

/**
Returns the arc tangent of e. Component-wise when T is a vector. (GLSLstd450Atan)

* T is `f32` or `vecN<f32>`
*/
fn atan(e: T) -> T {}

/**
Returns the arc tangent of e1 over e2. Component-wise when T is a vector. (GLSLstd450Atan2)

* T is `f32` or `vecN<f32>`
*/
fn atan2(e1: T, e2: T) -> T {}

/**
Returns the ceiling of e. Component-wise when T is a vector. (GLSLstd450Ceil)

* T is `f32` or `vecN<f32>`
*/
fn ceil(e: T) -> T {}

/**
Returns `min(max(e1,e2),e3)`. Component-wise when T is a vector. (GLSLstd450NClamp)

* T is `i32`, `f32`, `u32`, `vecN<i32>`, `vecN<f32>` or `vecN<u32>`
*/
fn clamp(e1: T, e2: T, e3: T) -> T {}

/**
Returns the cosine of e. Component-wise when T is a vector. (GLSLstd450Cos)

* T is `f32` or `vecN<f32>`
*/
fn cos(e: T) -> T {}

/**
Returns the hyperbolic cosine of e. Component-wise when T is a vector (GLSLstd450Cosh)

* T is `f32` or `vecN<f32>`
*/
fn cosh(e: T) -> T {}

/**
Returns the cross product of e1 and e2. (GLSLstd450Cross)

* T is `f32`
*/
fn cross(e1: vec3<T>, e2: vec3<T>) -> vec3<T> {}

/**
Converts radians to degrees, approximating e1 × 180 ÷ π. Component-wise when T is a vector
(GLSLstd450Degrees)

* T is `f32` or `vecN<f32>`
*/
fn degrees(e1: T) -> T {}

/**
Returns the distance between e1 and e2 (e.g. `length(e1-e2)`). (GLSLstd450Distance)

* T is `f32` or `vecN<f32>`
*/
fn distance(e1: T, e2: T) -> f32 {}

/**
Returns the natural exponentiation of e1 (e.g. e<sup>e1</sup>). Component-wise when T is a vector. (GLSLstd450Exp)

* T is `f32` or `vecN<f32>`
*/
fn exp(e1: T) -> T {}

/**
Returns 2 raised to the power e (e.g. 2<sup>e</sup>). Component-wise when T is a vector. (GLSLstd450Exp2)

* T is `f32` or `vecN<f32>`
*/
fn exp2(e: T) -> T {}

/**
Returns e1 if `dot(e2,e3)` is negative, and -e1 otherwise. (GLSLstd450FaceForward)

* T is `vecN<f32>`
*/
fn faceForward(e1: T, e2: T, e3: T) -> T {}

/**
Returns the floor of e. Component-wise when T is a vector. (GLSLstd450Floor)

* T is `f32` or `vecN<f32>`
*/
fn floor(e: T) -> T {}

/**
Returns `e1 * e2 + e3`. Component-wise when T is a vector. (GLSLstd450Fma)

* T is `f32` or `vecN<f32>`
*/
fn fma(e1: T, e2: T, e3: T) -> T {}

/**
Returns the fractional bits of e (e.g. `e - floor(e)`). Component-wise when T is a vector. (GLSLstd450Fract)

* T is `f32` or `vecN<f32>`
*/
fn fract(e: T) -> T {}

/**
Splits e into a significand and exponent of the form significand * 2<sup>exponent</sup>. Returns the `__frexp_result` built-in structure, defined as if as follows:

```wgsl
struct __frexp_result {
  sig : f32; // significand part
  exp : i32; // exponent part
};
```

The magnitude of the significand is in the range of `[0.5, 1.0)` or 0.
Note: A value cannot be explicitly declared with the type `__frexp_result`, but a value may infer the type.

EXAMPLE: FREXP USAGE

```wgsl
// Infers result type
let sig_and_exp = frexp(1.5);
// Sets fraction_direct to 0.75
let fraction_direct = frexp(1.5).sig;
```

(GLSLstd450FrexpStruct)

* T is `f32`
* R is `__frexp_result`
*/
fn frexp(e:T) -> R {}

/**
Splits the components of e into a significand and exponent of the form significand * 2<sup>exponent</sup>. Returns the `__frexp_result_vecN` built-in structure, defined as if as follows:

```wgsl
struct __frexp_result_vecN {
  sig : vecN<f32>; // significand part
  exp : vecN<i32>; // exponent part
};
```

The magnitude of each component of the significand is in the range of `[0.5, 1.0)` or 0.
Note: A value cannot be explicitly declared with the type `__frexp_result_vecN`, but a value may infer the type.
(GLSLstd450FrexpStruct)

* T is `vecN<f32>`
* R is `__frexp_result_vecN`
*/
fn frexp(e:T) -> R {}

/**
Returns the reciprocal of sqrt(e). Component-wise when T is a vector. (GLSLstd450InverseSqrt)

* T is `f32` or `vecN<f32>`
*/
fn inverseSqrt(e: T) -> T {}

/**
Returns e1 * 2<sup>e2</sup>. Component-wise when T is a vector. (GLSLstd450Ldexp)

* T is `f32` or `vecN<f32>`
* I is `i32` or `vecN<i32>`, where I is a scalar if T is a scalar, or a vector when T is a vector
*/
fn ldexp(e1: T, e2: I) -> T {}

/**
Returns the length of e (e.g. abs(e) if T is a scalar, or sqrt(e[0]<sup>2</sup> + e[1]<sup>2</sup> + ...) if T is a vector). (GLSLstd450Length)

* T is `f32` or `vecN<f32>`
*/
fn length(e: T) -> f32 {}

/**
Returns the natural logarithm of e. Component-wise when T is a vector. (GLSLstd450Log)

T is f32 or vecN<f32>
*/
fn log(e: T) -> T {}

/**
Returns the base-2 logarithm of e. Component-wise when T is a vector. (GLSLstd450Log2)

* T is `f32` or `vecN<f32>`
*/
fn log2(e: T) -> T {}

/**
Returns e2 if e1 is less than e2, and e1 otherwise. If one operand is a NaN, the other is returned. If both operands are NaNs, a NaN is returned. Component-wise when T is a vector. (GLSLstd450NMax)

* T is `i32`, `f32`, `u32`, `vecN<i32>`, `vecN<f32>` or `vecN<u32>`
*/
fn max(e1: T, e2: T) -> T {}

/**
Returns e2 if e2 is less than e1, and e1 otherwise. If one operand is a NaN, the other is returned. If both operands are NaNs, a NaN is returned. Component-wise when T is a vector. (GLSLstd450NMin)

* T is `i32`, `f32`, `u32`, `vecN<i32>`, `vecN<f32>` or `vecN<u32>`
*/
fn min(e1: T, e2: T) -> T {}

/**
Returns the linear blend of e1 and e2 (e.g. e1*(1-e3)+e2*e3). Component-wise when T is a vector.
(GLSLstd450FMix)

* T is `f32` or `vecN<f32>`
*/
fn mix(e1: T, e2: T,e3: T) -> T {}

/**
Returns the component-wise linear blend of e1 and e2, using scalar blending factor e3 for each component.
Same as `mix(e1,e2,T(e3))`.

* T is `vecN<f32>`
*/
fn mix(e1: T ,e2: T ,e3: f32 ) -> T {}

/**
Splits e into fractional and whole number parts. Returns the __modf_result built-in structure, defined as if as follows:

```wgsl
struct __modf_result {
  fract : f32; // fractional part
  whole : f32; // whole part
};
```

Note: A value cannot be explicitly declared with the type __modf_result, but a value may infer the type.

EXAMPLE: MODF USAGE

```wgsl
// Infers result type
let fract_and_whole = modf(1.5);
// Sets fract_direct to 0.5
let fract_direct = modf(1.5).fract;
```

(GLSLstd450ModfStruct)

* T is `f32`
* R is `__modf_result`
*/
fn modf(e:T) -> R {}

/**
Splits the components of e into fractional and whole number parts. Returns the __modf_result_vecN built-in structure, defined as if as follows:

```wgsl
struct __modf_result_vecN {
  fract : vecN<f32>; // fractional part
  whole : vecN<f32>; // whole part
};
```

Note: A value cannot be explicitly declared with the type __modf_result_vecN, but a value may infer the type.

(GLSLstd450ModfStruct)

* T is `vecN<f32>`
* R is `__modf_result_vecN`
*/
fn modf(e:T) -> R {}

/**
Returns a unit vector in the same direction as e. (GLSLstd450Normalize)

* T is `vec2<f32>`, `vec3<f32>` or `vec4<f32>`
*/
fn normalize(e: T) -> T {}

/**
Returns e1 raised to the power e2. Component-wise when T is a vector. (GLSLstd450Pow)

* T is `f32` or `vecN<f32>`
*/
fn pow(e1: T, e2: T) -> T {}

/**
Quantizes a 32-bit floating point value e as if e were converted to a IEEE 754 binary16 value, and then converted back to a IEEE 754 binary32 value.

Component-wise when T is a vector.
Note: The vec2<f32> case is the same as unpack2x16float(pack2x16float(e)).

(OpQuantizeToF16)

* T is `f32` or `vecN<f32>`
*/
fn quantizeToF16(e: T) -> T {}

/**
Converts degrees to radians, approximating e1 × π ÷ 180. Component-wise when T is a vector
(GLSLstd450Radians)

* T is `f32` or `vecN<f32>`
*/
fn radians(e1: T) -> T {}

/**
For the incident vector e1 and surface orientation e2, returns the reflection direction e1-2*dot(e2,e1)*e2. (GLSLstd450Reflect)

T is `vecN<f32>`
*/
fn reflect(e1: T, e2: T) -> T {}

/**
For the incident vector e1 and surface normal e2, and the ratio of indices of refraction e3, let k = 1.0 -e3*e3* (1.0 - dot(e2,e1) * dot(e2,e1)). If k < 0.0, returns the refraction vector 0.0, otherwise return the refraction vector e3*e1- (e3* dot(e2,e1) + sqrt(k)) *e2. (GLSLstd450Refract)

* T is `vecN<f32>`
* I is `f32`
*/
fn refract(e1: T, e2: T, e3: I) -> T {}

/**
Result is the integer k nearest to e, as a floating point value.
When e lies halfway between integers k and k+1, the result is k when k is even, and k+1 when k is odd.
Component-wise when T is a vector. (GLSLstd450RoundEven)

* T is `f32` or `vecN<f32>`
*/
fn round(e: T) -> T {}

/**
Returns clamp(e, 0.0, 1.0). Component-wise when T is a vector.

* T is `f32` or `vecN<f32>`
*/
fn saturate(e1: T) -> T {}

/**
Returns the sign of e. Component-wise when T is a vector. (GLSLstd450FSign)

* T is `f32` or `vecN<f32>`
*/
fn sign(e: T) -> T {}

/**
Returns the sine of e. Component-wise when T is a vector. (GLSLstd450Sin)

* T is `f32` or `vecN<f32>`
*/
fn sin(e: T) -> T {}

/**
Returns the hyperbolic sine of e. Component-wise when T is a vector. (GLSLstd450Sinh)

* T is `f32` or `vecN<f32>`
*/
fn sinh(e: T) -> T {}

/**
Returns the smooth Hermite interpolation between 0 and 1. Component-wise when T is a vector. (GLSLstd450SmoothStep)

* T is `f32` or `vecN<f32>`
*/
fn smoothstep(e1: T, e2: T, e3: T) -> T {}

/**
Returns the square root of e. Component-wise when T is a vector. (GLSLstd450Sqrt)

* T is `f32` or `vecN<f32>`
*/
fn sqrt(e: T) -> T {}

/**
Returns 0.0 if e1 is less than e2, and 1.0 otherwise. Component-wise when T is a vector. (GLSLstd450Step)

* T is `f32` or `vecN<f32>`
*/
fn step(e1: T, e2: T) -> T {}

/**
Returns the tangent of e. Component-wise when T is a vector. (GLSLstd450Tan)

* T is `f32` or `vecN<f32>`
*/
fn tan(e: T) -> T {}

/**
Returns the hyperbolic tangent of e. Component-wise when T is a vector. (GLSLstd450Tanh)

* T is `f32` or `vecN<f32>`
*/
fn tanh(e: T) -> T {}

/**
Returns the nearest whole number whose absolute value is less than or equal to e. Component-wise when T is a vector. (GLSLstd450Trunc)

* T is `f32` or `vecN<f32>`
*/
fn trunc(e: T) -> T {}

// integer functions

/**
The number of 1 bits in the representation of e.
Also known as "population count".
Component-wise when T is a vector. (SPIR-V OpBitCount)

* T is i32, u32, vecN<i32>, or vecN<u32>
*/
fn countOneBits(e: T) -> T {}

/**
Reverses the bits in e: The bit at position k of the result equals the bit at position 31-k of e.
Component-wise when T is a vector. (SPIR-V OpBitReverse)

* T is i32, u32, vecN<i32>, or vecN<u32>
*/
fn reverseBits(e: T) -> T {}

// matrix functions

/**
Returns the determinant of e. (GLSLstd450Determinant)

* M is matMxN<T>
* T is f32
*/
fn determinant(e: M) -> T {}

/**
Returns the transpose of e. (OpTranspose)

* M is matMxN<T>
* T is f32
* R if matNxM<T>
*/
fn transpose(e: M) -> R {}

// vector functions

/**
Returns the dot product of e1 and e2. (OpDot, SPV_KHR_integer_dot_product OpSDotKHR, SPV_KHR_integer_dot_product OpUDotKHR)

* V is vecN<T>
* T is i32, f32 or u32
*/
fn dot(e1: V, e2: V) -> T {}

// derivative functions

/**
Partial derivative of e with respect to window x coordinates. The result is the same as either dpdxFine(e) or dpdxCoarse(e). (OpDPdx)

* T is f32 or vecN<f32>
*/
fn dpdx(e: T) -> T {}

/**
Returns the partial derivative of e with respect to window x coordinates using local differences. This may result in fewer unique positions that dpdxFine(e). (OpDPdxCoarse)

* T is f32 or vecN<f32>
*/
fn dpdxCoarse(e: T) -> T {}

/**
Returns the partial derivative of e with respect to window x coordinates. (OpDPdxFine)

* T is f32 or vecN<f32>
*/
fn dpdxFine(e: T) -> T {}

/**
Partial derivative of e with respect to window y coordinates. The result is the same as either dpdyFine(e) or dpdyCoarse(e). (OpDPdy)

* T is f32 or vecN<f32>
*/
fn dpdy(e: T) -> T {}

/**
Returns the partial derivative of e with respect to window y coordinates using local differences. This may result in fewer unique positions that dpdyFine(e). (OpDPdyCoarse)

* T is f32 or vecN<f32>
*/
fn dpdyCoarse(e: T) -> T {}

/**
Returns the partial derivative of e with respect to window y coordinates. (OpDPdyFine)

* T is f32 or vecN<f32>
*/
fn dpdyFine(e: T) -> T {}

/**
Returns abs(dpdx(e)) + abs(dpdy(e)). (OpFwidth)

* T is f32 or vecN<f32>
*/
fn fwidth(e: T) -> T {}

/**
Returns abs(dpdxCoarse(e)) + abs(dpdyCoarse(e)). (OpFwidthCoarse)

* T is f32 or vecN<f32>
*/
fn fwidthCoarse(e: T) -> T {}

/**
Returns abs(dpdxFine(e)) + abs(dpdyFine(e)). (OpFwidthFine)

* T is f32 or vecN<f32>
*/
fn fwidthFine(e: T) -> T {}

/**
Returns the dimensions of a texture, or texture’s mip level in texels.

## Parameters
* t - The sampled, multisampled, depth, storage, or external texture.
* level - The mip level, with level 0 containing a full size version of the texture. If omitted, the dimensions of level 0 are returned.

## Types
* P is texture_1d<T>, texture_2d<T>, texture_2d_array<T>, texture_3d<T>, texture_cube<T>, texture_cube_array<T>, texture_multisampled_2d<T>, texture_depth_2d, texture_depth_2d_array, texture_depth_cube, texture_depth_cube_array, texture_depth_multisampled_2d, texture_storage_1d<F,A>, texture_storage_2d<F,A>, texture_storage_2d_array<F,A>, texture_storage_3d<F,A> or texture_external
* T is a sampled type.
* F is a texel format.
* A is an access mode.
* X is i32, vec2<i32> or vec3<i32>
*/
fn textureDimensions(t: P, level: i32) -> X { }
fn textureDimensions(t: texture_1d<T>) -> i32 { }
fn textureDimensions(t: texture_1d<T>, level: i32) -> i32 {}
fn textureDimensions(t: texture_2d<T>) -> vec2<i32> {}
fn textureDimensions(t: texture_2d<T>, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_2d_array<T>) -> vec2<i32> {}
fn textureDimensions(t: texture_2d_array<T>, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_3d<T>) -> vec3<i32> {}
fn textureDimensions(t: texture_3d<T>, level: i32) -> vec3<i32> {}
fn textureDimensions(t: texture_cube<T>) -> vec2<i32> {}
fn textureDimensions(t: texture_cube<T>, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_cube_array<T>) -> vec2<i32> {}
fn textureDimensions(t: texture_cube_array<T>, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_multisampled_2d<T>)-> vec2<i32> {}
fn textureDimensions(t: texture_depth_2d) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_2d, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_2d_array) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_2d_array, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_cube) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_cube, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_cube_array) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_cube_array, level: i32) -> vec2<i32> {}
fn textureDimensions(t: texture_depth_multisampled_2d)-> vec2<i32> {}
fn textureDimensions(t: texture_storage_1d<F,A>) -> i32 {}
fn textureDimensions(t: texture_storage_2d<F,A>) -> vec2<i32> {}
fn textureDimensions(t: texture_storage_2d_array<F,A>) -> vec2<i32> {}
fn textureDimensions(t: texture_storage_3d<F,A>) -> vec3<i32> {}
fn textureDimensions(t: texture_external) -> vec2<i32> {}


/**
A texture gather operation reads from a 2D, 2D array, cube, or cube array texture, computing a four-element vector

## Parameters
* component - Only applies to non-depth textures. The index of the channel to read from the selected texels. When provided, the component expression must be either:
    * a const_expression expression (e.g. 1).
    * a name of a module-scope constant that is not pipeline-overridable
  Its value must be at least 0 and at most 3. Values outside of this range will result in a shader-creation error.
* t - The sampled or depth texture to read from.
* s - The sampler type.
* coords - The texture coordinates.
* array_index - The 0-based texture array index.
* offset - The optional texel offset applied to the unnormalized texture coordinate before sampling the texture. This offset is applied before applying any texture wrapping modes. The offset expression must be either:
    * a const_expression expression (e.g. vec2<i32>(1, 2)).
    * a name of a module-scope constant that is not pipeline-overridable
  Each offset component must be at least -8 and at most 7. Values outside of this range will result in a shader-creation error.

## Returns
A four element vector with components extracted from the specified channel from the selected texels, as described above.

## EXAMPLE: GATHER COMPONENTS FROM TEXELS IN 2D TEXTURE

```wgsl
[[group(0),binding(0)]] var t: texture_2d<f32>;
[[group(0),binding(1)]] var dt: texture_depth_2d;
[[group(0),binding(2)]] var s: sampler;

fn gather_x_components(c: vec2<f32>) -> vec4<f32> {
  return textureGather(0,t,s,c);
}
fn gather_y_components(c: vec2<f32>) -> vec4<f32> {
  return textureGather(1,t,s,c);
}
fn gather_z_components(c: vec2<f32>) -> vec4<f32> {
  return textureGather(2,t,s,c);
}
fn gather_depth_components(c: vec2<f32>) -> vec4<f32> {
  return textureGather(dt,s,c);
}
```
*/
fn textureGather(component: i32, t: texture_2d_array<T>, s: sampler, coords: vec2<f32>, array_index: i32, offset: vec2<i32>) -> vec4<T> {}
fn textureGather(component: i32, t: texture_2d<T>, s: sampler, coords: vec2<f32>) -> vec4<T> {}
fn textureGather(component: i32, t: texture_2d<T>, s: sampler, coords: vec2<f32>, offset: vec2<i32>) -> vec4<T> {}
fn textureGather(component: i32, t: texture_2d_array<T>, s: sampler, coords: vec2<f32>, array_index: i32) -> vec4<T> {}
fn textureGather(component: i32, t: texture_cube<T>, s: sampler, coords: vec3<f32>) -> vec4<T> {}
fn textureGather(component: i32, t: texture_cube_array<T>, s: sampler, coords: vec3<f32>, array_index: i32) -> vec4<T> {}
fn textureGather(t: texture_depth_2d, s: sampler, coords: vec2<f32>) -> vec4<f32> {}
fn textureGather(t: texture_depth_2d, s: sampler, coords: vec2<f32>, offset: vec2<i32>) -> vec4<f32> {}
fn textureGather(t: texture_depth_2d_array, s: sampler, coords: vec2<f32>, array_index: i32) -> vec4<f32> {}
fn textureGather(t: texture_depth_2d_array, s: sampler, coords: vec2<f32>, array_index: i32, offset: vec2<i32>) -> vec4<f32> {}
fn textureGather(t: texture_depth_cube, s: sampler, coords: vec3<f32>) -> vec4<f32> {}
fn textureGather(t: texture_depth_cube_array, s: sampler, coords: vec3<f32>, array_index: i32) -> vec4<f32> {}

/**
A texture gather compare operation performs a depth comparison on four texels in a depth texture and collects the results into a single vector

## Parameters
* t - The depth texture to read from.
* s - The sampler comparison.
* coords - The texture coordinates.
* array_index - The 0-based texture array index.
* depth_ref - The reference value to compare the sampled depth value against.
offset	The optional texel offset applied to the unnormalized texture coordinate before sampling the texture. This offset is applied before applying any texture wrapping modes.
The offset expression must be either:
  * a const_expression expression (e.g. vec2<i32>(1, 2)).
  * a name of a module-scope constant that is not pipeline-overridable

  Each offset component must be at least -8 and at most 7. Values outside of this range will result in a shader-creation error.

## Returns
A four element vector with comparison result for the selected texels, as described above.

## EXAMPLE: GATHER DEPTH COMPARISON
```wgsl
[[group(0),binding(0)]] var dt: texture_depth_2d;
[[group(0),binding(1)]] var s: sampler;

fn gather_depth_compare(c: vec2<f32>, depth_ref: f32) -> vec4<f32> {
  return textureGatherCompare(dt,s,c,depth_ref);
}
```
*/
fn textureGatherCompare(t: texture_depth_2d_array, s: sampler_comparison, coords: vec2<f32>, array_index: i32, depth_ref: f32, offset: vec2<i32>) -> vec4<f32> {}
fn textureGatherCompare(t: texture_depth_2d, s: sampler_comparison, coords: vec2<f32>, depth_ref: f32) -> vec4<f32> {}
fn textureGatherCompare(t: texture_depth_2d, s: sampler_comparison, coords: vec2<f32>, depth_ref: f32, offset: vec2<i32>) -> vec4<f32> {}
fn textureGatherCompare(t: texture_depth_2d_array, s: sampler_comparison, coords: vec2<f32>, array_index: i32, depth_ref: f32) -> vec4<f32> {}
fn textureGatherCompare(t: texture_depth_cube, s: sampler_comparison, coords: vec3<f32>, depth_ref: f32) -> vec4<f32> {}
fn textureGatherCompare(t: texture_depth_cube_array, s: sampler_comparison, coords: vec3<f32>, array_index: i32, depth_ref: f32) -> vec4<f32> {}

/**
Reads a single texel from a texture without sampling or filtering.

## Parameters
* t - The sampled, multisampled, depth, or external texture.
* coords - The 0-based texel coordinate.
* array_index - The 0-based texture array index.
* level - The mip level, with level 0 containing a full size version of the texture.
* sample_index - The 0-based sample index of the multisampled texture.

## Returns
The unfiltered texel data.
*/
fn textureLoad(t: texture_1d<T>, coords: i32, level: i32) -> vec4<T> {}
fn textureLoad(t: texture_2d<T>, coords: vec2<i32>, level: i32) -> vec4<T> {}
fn textureLoad(t: texture_2d_array<T>, coords: vec2<i32>, array_index: i32, level: i32) -> vec4<T> {}
fn textureLoad(t: texture_3d<T>, coords: vec3<i32>, level: i32) -> vec4<T> {}
fn textureLoad(t: texture_multisampled_2d<T>, coords: vec2<i32>, sample_index: i32)-> vec4<T> {}
fn textureLoad(t: texture_depth_2d, coords: vec2<i32>, level: i32) -> f32 {}
fn textureLoad(t: texture_depth_2d_array, coords: vec2<i32>, array_index: i32, level: i32) -> f32 {}
fn textureLoad(t: texture_depth_multisampled_2d, coords: vec2<i32>, sample_index: i32)-> f32 {}
fn textureLoad(t: texture_external, coords: vec2<i32>) -> vec4<f32> {}

/**
Returns the number of layers (elements) of an array texture.

## Parameters
* t - The sampled, multisampled, depth or storage array texture.

## Returns
The number of layers (elements) of the array texture.
*/
fn textureNumLayers(t: texture_2d_array<T>) -> i32 {}
fn textureNumLayers(t: texture_cube_array<T>) -> i32 {}
fn textureNumLayers(t: texture_depth_2d_array) -> i32 {}
fn textureNumLayers(t: texture_depth_cube_array) -> i32 {}
fn textureNumLayers(t: texture_storage_2d_array<F,A>) -> i32 {}


/**
Returns the number samples per texel in a multisampled texture.

## Parameters

* t - The multisampled texture.

## Returns

If the number of samples per texel in the multisampled texture.
*/
fn textureNumSamples(t: texture_multisampled_2d<T>) -> i32 {}
fn textureNumSamples(t: texture_depth_multisampled_2d) -> i32 {}

/** Samples a texture.

Must only be used in a fragment shader stage. Must only be invoked in uniform control flow.

## Parameters
* t - The sampled, depth, or external texture to sample.
* s - The sampler type.
* coords - The texture coordinates used for sampling.
* array_index - The 0-based texture array index to sample.
* offset - The optional texel offset applied to the unnormalized texture coordinate before sampling the texture. This offset is applied before applying any texture wrapping modes.

The offset expression must be either:
* a const_expression expression (e.g. vec2<i32>(1, 2)).
* a name of a module-scope constant that is not pipeline-overridable

Each offset component must be at least -8 and at most 7. Values outside of this range will result in a shader-creation error.

## Returns
The sampled value.
*/
fn textureSample(t: texture_1d<f32>, s: sampler, coords: f32) -> vec4<f32> {}
fn textureSample(t: texture_2d<f32>, s: sampler, coords: vec2<f32>) -> vec4<f32> {}
fn textureSample(t: texture_2d<f32>, s: sampler, coords: vec2<f32>, offset: vec2<i32>) -> vec4<f32> {}
fn textureSample(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32) -> vec4<f32> {}
fn textureSample(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32, offset: vec2<i32>) -> vec4<f32> {}
fn textureSample(t: texture_3d<f32>, s: sampler, coords: vec3<f32>) -> vec4<f32> {}
fn textureSample(t: texture_3d<f32>, s: sampler, coords: vec3<f32>, offset: vec3<i32>) -> vec4<f32> {}
fn textureSample(t: texture_cube<f32>, s: sampler, coords: vec3<f32>) -> vec4<f32> {}
fn textureSample(t: texture_cube_array<f32>, s: sampler, coords: vec3<f32>, array_index: i32) -> vec4<f32> {}
fn textureSample(t: texture_depth_2d, s: sampler, coords: vec2<f32>) -> f32 {}
fn textureSample(t: texture_depth_2d, s: sampler, coords: vec2<f32>, offset: vec2<i32>) -> f32 {}
fn textureSample(t: texture_depth_2d_array, s: sampler, coords: vec2<f32>, array_index: i32) -> f32 {}
fn textureSample(t: texture_depth_2d_array, s: sampler, coords: vec2<f32>, array_index: i32, offset: vec2<i32>) -> f32 {}
fn textureSample(t: texture_depth_cube, s: sampler, coords: vec3<f32>) -> f32 {}
fn textureSample(t: texture_depth_cube_array, s: sampler, coords: vec3<f32>, array_index: i32) -> f32 {}

/**
Samples a texture with a bias to the mip level.

Must only be used in a fragment shader stage. Must only be invoked in uniform control flow.

## Parameters
* t - The texture to sample.
* s - The sampler type.
* coords - The texture coordinates used for sampling.
* array_index - The 0-based texture array index to sample.
* bias - The bias to apply to the mip level before sampling. bias must be between -16.0 and 15.99.
* offset - The optional texel offset applied to the unnormalized texture coordinate before sampling the texture. This offset is applied before applying any texture wrapping modes.

The offset expression must be a const_expression expression (e.g. vec2<i32>(1, 2)).
Each offset component must be at least -8 and at most 7. Values outside of this range will result in a shader-creation error.

## Returns
The sampled value.
*/
fn textureSampleBias(t: texture_2d<f32>, s: sampler, coords: vec2<f32>, bias: f32) -> vec4<f32> {}
fn textureSampleBias(t: texture_2d<f32>, s: sampler, coords: vec2<f32>, bias: f32, offset: vec2<i32>) -> vec4<f32> {}
fn textureSampleBias(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32, bias: f32) -> vec4<f32> {}
fn textureSampleBias(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32, bias: f32, offset: vec2<i32>) -> vec4<f32> {}
fn textureSampleBias(t: texture_3d<f32>, s: sampler, coords: vec3<f32>, bias: f32) -> vec4<f32> {}
fn textureSampleBias(t: texture_3d<f32>, s: sampler, coords: vec3<f32>, bias: f32, offset: vec3<i32>) -> vec4<f32> {}
fn textureSampleBias(t: texture_cube<f32>, s: sampler, coords: vec3<f32>, bias: f32) -> vec4<f32> {}
fn textureSampleBias(t: texture_cube_array<f32>, s: sampler, coords: vec3<f32>, array_index: i32, bias: f32) -> vec4<f32> {}

/**
Samples a depth texture and compares the sampled depth values against a reference value.

Must only be used in a fragment shader stage. Must only be invoked in uniform control flow.

## Parameters
* t - The depth texture to sample.
* s - The sampler comparision type.
* coords - The texture coordinates used for sampling.
* array_index - The 0-based texture array index to sample.
* depth_ref - The reference value to compare the sampled depth value against.
* offset - The optional texel offset applied to the unnormalized texture coordinate before sampling the texture. This offset is applied before applying any texture wrapping modes.

The offset expression must be a const_expression expression (e.g. vec2<i32>(1, 2)).
Each offset component must be at least -8 and at most 7. Values outside of this range will result in a shader-creation error.

## Returns
A value in the range [0.0..1.0].
Each sampled texel is compared against the reference value using the comparision operator defined by the sampler_comparison, resulting in either a 0 or 1 value for each texel.
If the sampler uses bilinear filtering then the returned value is the filtered average of these values, otherwise the comparision result of a single texel is returned.
*/
fn textureSampleCompare(t: texture_depth_2d, s: sampler_comparison, coords: vec2<f32>, depth_ref: f32) -> f32 {}
fn textureSampleCompare(t: texture_depth_2d, s: sampler_comparison, coords: vec2<f32>, depth_ref: f32, offset: vec2<i32>) -> f32 {}
fn textureSampleCompare(t: texture_depth_2d_array, s: sampler_comparison, coords: vec2<f32>, array_index: i32, depth_ref: f32) -> f32 {}
fn textureSampleCompare(t: texture_depth_2d_array, s: sampler_comparison, coords: vec2<f32>, array_index: i32, depth_ref: f32, offset: vec2<i32>) -> f32 {}
fn textureSampleCompare(t: texture_depth_cube, s: sampler_comparison, coords: vec3<f32>, depth_ref: f32) -> f32 {}
fn textureSampleCompare(t: texture_depth_cube_array, s: sampler_comparison, coords: vec3<f32>, array_index: i32, depth_ref: f32) -> f32 {}

/**
Samples a depth texture and compares the sampled depth values against a reference value.

The textureSampleCompareLevel function is the same as textureSampleCompare, except that:
* textureSampleCompareLevel always samples texels from mip level 0.

The function does not compute derivatives.
There is no requirement for textureSampleCompareLevel to be invoked in uniform control flow.

textureSampleCompareLevel may be invoked in any shader stage.
*/
fn textureSampleCompareLevel(t: texture_depth_2d, s: sampler_comparison, coords: vec2<f32>, depth_ref: f32) -> f32 {}
fn textureSampleCompareLevel(t: texture_depth_2d, s: sampler_comparison, coords: vec2<f32>, depth_ref: f32, offset: vec2<i32>) -> f32 {}
fn textureSampleCompareLevel(t: texture_depth_2d_array, s: sampler_comparison, coords: vec2<f32>, array_index: i32, depth_ref: f32) -> f32 {}
fn textureSampleCompareLevel(t: texture_depth_2d_array, s: sampler_comparison, coords: vec2<f32>, array_index: i32, depth_ref: f32, offset: vec2<i32>) -> f32 {}
fn textureSampleCompareLevel(t: texture_depth_cube, s: sampler_comparison, coords: vec3<f32>, depth_ref: f32) -> f32 {}
fn textureSampleCompareLevel(t: texture_depth_cube_array, s: sampler_comparison, coords: vec3<f32>, array_index: i32, depth_ref: f32) -> f32 {}

/**
Samples a texture using explicit gradients.

## Parameters
* t - The texture to sample.
* s - The sampler type.
* coords - The texture coordinates used for sampling.
* array_index - The 0-based texture array index to sample.
* ddx - The x direction derivative vector used to compute the sampling locations.
* ddy - The y direction derivative vector used to compute the sampling locations.
* offset - The optional texel offset applied to the unnormalized texture coordinate before sampling the texture. This offset is applied before applying any texture wrapping modes.

The offset expression must be a const_expression expression (e.g. vec2<i32>(1, 2)).
Each offset component must be at least -8 and at most 7. Values outside of this range will result in a shader-creation error.

##Returns
The sampled value.
*/
fn textureSampleGrad(t: texture_2d<f32>, s: sampler, coords: vec2<f32>, ddx: vec2<f32>, ddy: vec2<f32>) -> vec4<f32> {}
fn textureSampleGrad(t: texture_2d<f32>, s: sampler, coords: vec2<f32>, ddx: vec2<f32>, ddy: vec2<f32>, offset: vec2<i32>) -> vec4<f32> {}
fn textureSampleGrad(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32, ddx: vec2<f32>, ddy: vec2<f32>) -> vec4<f32> {}
fn textureSampleGrad(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32, ddx: vec2<f32>, ddy: vec2<f32>, offset: vec2<i32>) -> vec4<f32> {}
fn textureSampleGrad(t: texture_3d<f32>, s: sampler, coords: vec3<f32>, ddx: vec3<f32>, ddy: vec3<f32>) -> vec4<f32> {}
fn textureSampleGrad(t: texture_3d<f32>, s: sampler, coords: vec3<f32>, ddx: vec3<f32>, ddy: vec3<f32>, offset: vec3<i32>) -> vec4<f32> {}
fn textureSampleGrad(t: texture_cube<f32>, s: sampler, coords: vec3<f32>, ddx: vec3<f32>, ddy: vec3<f32>) -> vec4<f32> {}
fn textureSampleGrad(t: texture_cube_array<f32>, s: sampler, coords: vec3<f32>, array_index: i32, ddx: vec3<f32>, ddy: vec3<f32>) -> vec4<f32> {}

/**
Samples a texture using an explicit mip level, or at mip level 0.

## Parameters
* t - The sampled or depth texture to sample.
* s - The sampler type.
* coords - The texture coordinates used for sampling.
* array_index - The 0-based texture array index to sample.
* level - The mip level, with level 0 containing a full size version of the texture. For the functions where level is a f32, fractional values may interpolate between two levels if the format is filterable according to the Texture Format Capabilities. When not specified, mip level 0 is sampled.
* offset - The optional texel offset applied to the unnormalized texture coordinate before sampling the texture. This offset is applied before applying any texture wrapping modes.

The offset expression must be a const_expression expression (e.g. vec2<i32>(1, 2)).
Each offset component must be at least -8 and at most 7. Values outside of this range will result in a shader-creation error.

## Returns
The sampled value.
*/
fn textureSampleLevel(t: texture_2d<f32>, s: sampler, coords: vec2<f32>, level: f32) -> vec4<f32> {}
fn textureSampleLevel(t: texture_2d<f32>, s: sampler, coords: vec2<f32>, level: f32, offset: vec2<i32>) -> vec4<f32> {}
fn textureSampleLevel(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32, level: f32) -> vec4<f32> {}
fn textureSampleLevel(t: texture_2d_array<f32>, s: sampler, coords: vec2<f32>, array_index: i32, level: f32, offset: vec2<i32>) -> vec4<f32> {}
fn textureSampleLevel(t: texture_3d<f32>, s: sampler, coords: vec3<f32>, level: f32) -> vec4<f32> {}
fn textureSampleLevel(t: texture_3d<f32>, s: sampler, coords: vec3<f32>, level: f32, offset: vec3<i32>) -> vec4<f32> {}
fn textureSampleLevel(t: texture_cube<f32>, s: sampler, coords: vec3<f32>, level: f32) -> vec4<f32> {}
fn textureSampleLevel(t: texture_cube_array<f32>, s: sampler, coords: vec3<f32>, array_index: i32, level: f32) -> vec4<f32> {}
fn textureSampleLevel(t: texture_depth_2d, s: sampler, coords: vec2<f32>, level: i32) -> f32 {}
fn textureSampleLevel(t: texture_depth_2d, s: sampler, coords: vec2<f32>, level: i32, offset: vec2<i32>) -> f32 {}
fn textureSampleLevel(t: texture_depth_2d_array, s: sampler, coords: vec2<f32>, array_index: i32, level: i32) -> f32 {}
fn textureSampleLevel(t: texture_depth_2d_array, s: sampler, coords: vec2<f32>, array_index: i32, level: i32, offset: vec2<i32>) -> f32 {}
fn textureSampleLevel(t: texture_depth_cube, s: sampler, coords: vec3<f32>, level: i32) -> f32 {}
fn textureSampleLevel(t: texture_depth_cube_array, s: sampler, coords: vec3<f32>, array_index: i32, level: i32) -> f32 {}
fn textureSampleLevel(t: texture_external, s: sampler, coords: vec2<f32>) -> vec4<f32> {}

/**
Writes a single texel to a texture.
The channel format T depends on the storage texel format F. See the texel format table for the mapping of texel format to channel format.

## Parameters
* t - The write-only storage texture.
* coords - The 0-based texel coordinate.
* array_index - The 0-based texture array index.
* value - The new texel value.

## Note

An out-of-bounds access occurs if:
* any element of coords is outside the range [0, textureDimensions(t)) for the corresponding element, or
* array_index is outside the range of [0, textureNumLayers(t))

If an out-of-bounds access occurs, the built-in function may do any of the following:
* not be executed
* store value to some in bounds texel
*/
fn textureStore(t: texture_storage_1d<F,write>, coords: i32, value: vec4<T>) {}
fn textureStore(t: texture_storage_2d<F,write>, coords: vec2<i32>, value: vec4<T>) {}
fn textureStore(t: texture_storage_2d_array<F,write>, coords: vec2<i32>, array_index: i32, value: vec4<T>) {}
fn textureStore(t: texture_storage_3d<F,write>, coords: vec3<i32>, value: vec4<T>) {}

// atomic functions

/**
Returns the atomically loaded the value pointed to by atomic_ptr. It does not modify the object.
*/
fn atomicLoad(atomic_ptr: ptr<AS, atomic<T>, read_write>) -> T {}

/**
Atomically stores the value v in the atomic object pointed to by atomic_ptr.
*/
fn atomicStore(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) {}

/**
Atomically performs an addition operation on the atomic object pointed to by atomic_ptr with the value v, and returns the original value stored in the atomic object before the operation.
*/
fn atomicAdd(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Atomically performs a subtraction operation on the atomic object pointed to by atomic_ptr with the value v, and returns the original value stored in the atomic object before the operation.
*/
fn atomicSub(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Atomically performs a maximum operation on the atomic object pointed to by atomic_ptr with the value v, and returns the original value stored in the atomic object before the operation.
*/
fn atomicMax(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Atomically performs a minimum operation on the atomic object pointed to by atomic_ptr with the value v, and returns the original value stored in the atomic object before the operation.
*/
fn atomicMin(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Atomically performs a bitwise AND operation on the atomic object pointed to by atomic_ptr with the value v, and returns the original value stored in the atomic object before the operation.
*/
fn atomicAnd(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Atomically performs a bitwise OR operation on the atomic object pointed to by atomic_ptr with the value v, and returns the original value stored in the atomic object before the operation.
*/
fn atomicOr(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Atomically performs a bitwise XOR operation on the atomic object pointed to by atomic_ptr with the value v, and returns the original value stored in the atomic object before the operation.
*/
fn atomicXor(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Atomically stores the value v in the atomic object pointed to by atomic_ptr and returns the original value stored in the atomic object before the operation.
*/
fn atomicExchange(atomic_ptr: ptr<AS, atomic<T>, read_write>, v: T) -> T {}

/**
Performs the following steps atomically:

1. Load the original value pointed to by atomic_ptr.
2. Compare the original value to the value cmp using an equality operation.
3. Store the value v only if the result of the equality comparison was true.

Returns a two member structure, where the first member, old_value, is the original value of the atomic object before the operation and the second member, exchanged, is whether or not the comparison succeeded.
*/
fn atomicCompareExchangeWeak(
      atomic_ptr: ptr<AS, atomic<T>, read_write>,
      cmp: T,
      v: T) -> __atomic_compare_exchange_result<T> {}

// packing functions

/**
Converts four normalized floating point values to 8-bit signed integers, and then combines them into one u32 value.
Component e[i] of the input is converted to an 8-bit twos complement integer value ⌊ 0.5 + 127 × min(1, max(-1, e[i])) ⌋ which is then placed in bits 8 × i through 8 × i + 7 of the result.
*/
fn pack4x8snorm(e: vec4<f32>) -> u32 {}

/**
Converts four normalized floating point values to 8-bit unsigned integers, and then combines them into one u32 value.
Component e[i] of the input is converted to an 8-bit unsigned integer value ⌊ 0.5 + 255 × min(1, max(0, e[i])) ⌋ which is then placed in bits 8 × i through 8 × i + 7 of the result.
*/
fn pack4x8unorm(e: vec4<f32>) -> u32 {}

/**
Pack the lower 8 bits of each component of e into a u32 value and drop all the unused bits.
Component e[i] of the input is mapped to bits 8 × i through 8 × i + 7 of the result.
*/
fn pack4xI8(e: vec4<i32>) -> u32 {}

/**
Pack the lower 8 bits of each component of e into a u32 value and drop all the unused bits.
Component e[i] of the input is mapped to bits 8 × i through 8 × i + 7 of the result.
*/
fn pack4xU8(e: vec4<u32>) -> u32 {}

/**
Clamp each component of e in the range [-128, 127] and then pack the lower 8 bits of each component into a u32 value.
Component e[i] of the input is mapped to bits 8 × i through 8 × i + 7 of the result.
*/
fn pack4xI8Clamp(e: vec4<i32>) -> u32 {}

/**
Clamp each component of e in the range of [0, 255] and then pack the lower 8 bits of each component into a u32 value.
Component e[i] of the input is mapped to bits 8 × i through 8 × i + 7 of the result.
*/
fn pack4xU8Clamp(e: vec4<u32>) -> u32 {}

/**
Converts two normalized floating point values to 16-bit signed integers, and then combines them into one u32 value.
Component e[i] of the input is converted to a 16-bit twos complement integer value ⌊ 0.5 + 32767 × min(1, max(-1, e[i])) ⌋ which is then placed in bits 16 × i through 16 × i + 15 of the result.
*/
fn pack2x16snorm(e: vec2<f32>) -> u32 {}

/**
Converts two normalized floating point values to 16-bit unsigned integers, and then combines them into one u32 value.
Component e[i] of the input is converted to a 16-bit unsigned integer value ⌊ 0.5 + 65535 × min(1, max(0, e[i])) ⌋ which is then placed in bits 16 × i through 16 × i + 15 of the result.
*/
fn pack2x16unorm(e: vec2<f32>) -> u32 {}

/**
Converts two floating point values to half-precision floating point numbers, and then combines them into one u32 value.
Component e[i] of the input is converted to a IEEE-754 binary16 value, which is then placed in bits 16 × i through 16 × i + 15 of the result. See § 15.7.6 Floating Point Conversion.
If either e[0] or e[1] is outside the finite range of binary16 then:

* It is a shader-creation error if e is a const-expression.
* It is a pipeline-creation error if e is an override-expression.
* Otherwise the result is an indeterminate value for u32.
*/
fn pack2x16float(e: vec2<f32>) -> u32 {}

// unpacking functions

/**
Decomposes a 32-bit value into four 8-bit chunks, then reinterprets each chunk as a signed normalized floating point value.
Component i of the result is max(v ÷ 127, -1), where v is the interpretation of bits 8×i through 8×i + 7 of e as a twos-complement signed integer.
*/
fn unpack4x8snorm(e: u32) -> vec4<f32> {}

/**
Decomposes a 32-bit value into four 8-bit chunks, then reinterprets each chunk as an unsigned normalized floating point value.
Component i of the result is v ÷ 255, where v is the interpretation of bits 8×i through 8×i + 7 of e as an unsigned integer.
*/
fn unpack4x8unorm(e: u32) -> vec4<f32> {}

/**
e is interpreted as a vector with four 8-bit signed integer components. Unpack e into a vec4<i32> with sign extension.
*/
fn unpack4xI8(e: u32) -> vec4<i32> {}

/**
e is interpreted as a vector with four 8-bit unsigned integer components. Unpack e into a vec4<u32> with zero extension.
*/
fn unpack4xU8(e: u32) -> vec4<u32> {}

/**
Decomposes a 32-bit value into two 16-bit chunks, then reinterprets each chunk as a signed normalized floating point value.
Component i of the result is max(v ÷ 32767, -1), where v is the interpretation of bits 16×i through 16×i + 15 of e as a twos-complement signed integer.
*/
fn unpack2x16snorm(e: u32) -> vec2<f32> {}

/**
	Decomposes a 32-bit value into two 16-bit chunks, then reinterprets each chunk as an unsigned normalized floating point value.
Component i of the result is v ÷ 65535, where v is the interpretation of bits 16×i through 16×i + 15 of e as an unsigned integer.
*/
fn unpack2x16unorm(e: u32) -> vec2<f32> {}

/**
Decomposes a 32-bit value into two 16-bit chunks, and reinterpets each chunk as a floating point value.
Component i of the result is the f32 representation of v, where v is the interpretation of bits 16×i through 16×i + 15 of e as an IEEE-754 binary16 value. See § 15.7.6 Floating Point Conversion.
*/
fn unpack2x16float(e: u32) -> vec2<f32> {}

// synchronization functions

/**
Executes a control barrier synchronization function that affects memory and atomic operations in the storage address space.
*/
fn storageBarrier() {}

/**
Executes a control barrier synchronization function that affects memory operations in the handle address space.
*/
fn textureBarrier() {}

/**
Executes a control barrier synchronization function that affects memory and atomic operations in the workgroup address space.
*/
fn workgroupBarrier() {}

/**
Returns the value pointed to by p to all invocations in the workgroup. The return value is uniform. p must be a uniform value.
Executes a control barrier synchronization function that affects memory and atomic operations in the workgroup address space.
*/
fn workgroupUniformLoad(p : ptr<workgroup, T>) -> T {}

/**
Atomically loads the value pointed to by p and returns it to all invocations in the workgroup. The return value is uniform. p must be a uniform value.
Executes a control barrier synchronization function that affects memory and atomic operations in the workgroup address space.
*/
fn workgroupUniformLoad(p : ptr<workgroup, atomic<T>, read_write>) -> T {}

// subgroup functions

/**
Reduction operation.
Returns the sum of e among all active invocations in the subgroup.
*/
fn subgroupAdd(e : T) -> T {}

/**
Exclusive prefix scan operation.
Returns the sum of e among all active invocations in the subgroup whose subgroup invocation IDs are less than the current invocation’s id.

The value returned for the invocation with the lowest id among active invocations is T(0).
*/
fn subgroupExclusiveAdd(e : T) -> T {}

/**
Inclusive prefix scan operation.
Returns the sum of e among all active invocations in the subgroup whose subgroup invocation IDs are less than or equal to the current invocation’s id.

## Note
equivalent to subgroupExclusiveAdd(x) + x.
*/
fn subgroupInclusiveAdd(e : T) -> T {}

/**
Returns true if e is true for all active invocations in the subgroup.
*/
fn subgroupAll(e : bool) -> bool {}

/**
Reduction operation.
Returns the bitwise and (&) of e among all active invocations in the subgroup.
*/
fn subgroupAnd(e : T) -> T {}

/**
Returns true if e is true for any active invocations in the subgroup.
*/
fn subgroupAny(e : bool) -> bool {}

/**
Returns a bitmask of the active invocations in the subgroup for whom pred is true.
* The x component of the return value contains invocations 0 through 31.
* The y component of the return value contains invocations 32 through 63.
* The z component of the return value contains invocations 64 through 95.
* The w component of the return value contains invocations 96 through 127.

Within each component, the IDs are in ascending order by bit position (e.g. ID 32 is at bit position 0 in the y component).
*/
fn subgroupBallot(pred : bool) -> vec4<u32> {}

/**
Returns the value of e from the invocation whose subgroup invocation ID matches id in the subgroup to all active invocations in the subgroup.
id must be a const-expression in the range [0, 128).

It is a dynamic error if id does not select an active invocation.

Note: If a non-constant version of id is required, use subgroupShuffle instead.
*/
fn subgroupBroadcast(e : T, id : I) -> T {}

/**
Returns the value of e from the invocation that has the lowest subgroup invocation ID among active invocations in the subgroup to all active invocations in the subgroup.
*/
fn subgroupBroadcastFirst(e : T) -> T {}

/**
Returns true if the current invocation has the lowest subgroup invocation ID among active invocations in the subgroup.
*/
fn subgroupElect() -> bool {}

/**
Reduction operation.
Returns the maximum value of e among all active invocations in the subgroup.
*/
fn subgroupMax(e : T) -> T {}

/**
Reduction operation.
Returns the minimum value of e among all active invocations in the subgroup.
*/
fn subgroupMin(e : T) -> T {}

/**
Reduction operation.
Returns the product of e among all active invocations in the subgroup.
*/
fn subgroupMul(e : T) -> T {}

/**
Exclusive prefix scan operation.
Returns the product of e among all active invocations in the subgroup whose subgroup invocation IDs are less than the current invocation’s id.

The value returned for the invocation with the lowest id among active invocations is T(1).
*/
fn subgroupExclusiveMul(e : T) -> T {}

/**
Inclusive prefix scan operation.
Returns the product of e among all active invocations in the subgroup whose subgroup invocation IDs are less than or equal to the current invocation’s id.

## Note
equivalent to subgroupExclusiveMul(x) * x.
*/
fn subgroupInclusiveMul(e : T) -> T {}

/**
Reduction operation.
Returns the bitwise or (|) of e among all active invocations in the subgroup.
*/
fn subgroupOr(e : T) -> T {}

/**
Returns e from the invocation whose subgroup invocation ID matches id.
If id is outside the range [0, 128), then:
* It is a shader-creation error if id is a const-expression.
* It is a pipeline-creation error if id is an override-expression.

An indeterminate value is returned if id does not select an active invocation.
*/
fn subgroupShuffle(e : T, id : I) -> T {}

/**
Returns e from the invocation whose subgroup invocation ID matches subgroup_invocation_id + delta for the current invocation.
If delta is greater than 127, then:
* It is a shader-creation error if delta is a const-expression.
* It is a pipeline-creation error if delta is an override-expression.

A subgroup_uniformity diagnostic is triggered if delta is not a uniform value. An indeterminate value is returned if subgroup_invocation_id + delta does not select an active invocation or if delta is a not a uniform value within the subgroup.
*/
fn subgroupShuffleDown(e : T, delta : u32) -> T {}

/**
Returns e from the invocation whose subgroup invocation ID matches subgroup_invocation_id - delta for the current invocation.
If delta is greater than 127, then:
* It is a shader-creation error if delta is a const-expression.
* It is a pipeline-creation error if delta is an override-expression.

A subgroup_uniformity diagnostic is triggered if delta is not a uniform value. An indeterminate value is returned if subgroup_invocation_id - delta does not select an active invocation or if delta is not a uniform value within the subgroup.
*/
fn subgroupShuffleUp(e : T, delta : u32) -> T {}

/**
Returns e from the invocation whose subgroup invocation ID matches subgroup_invocation_id ^ mask for the current invocation.
If mask is greater than 127, then:
* It is a shader-creation error if mask is a const-expression.
* It is a pipeline-creation error if mask is an override-expression.

A subgroup_uniformity diagnostic is triggered if mask is not a uniform value. An indeterminate value is returned if mask does not select an active invocation or if mask is not a uniform value within the subgroup.
*/
fn subgroupShuffleXor(e : T,  mask : u32) -> T {}

/**
Reduction operation.
Returns the bitwise xor (^) of e among all active invocations in the subgroup.
*/
fn subgroupXor(e : T) -> T {}

// quad functions

/**
Returns the value of e from the invocation whose quad invocation ID matches id in the quad to all active invocations in the quad.
id must be a const-expression in the range [0, 4).

An indeterminate value is returned if id does not select an active invocation.

## Note
Unlike subgroupBroadcast, there is currently no non-constant alternative.
*/
fn quadBroadcast(e : T, id : I) -> T {}

/**
Returns the value of e from the invocation in the quad with the opposite coordinates. That is:
* IDs 0 and 3 swap.
* IDs 1 and 2 swap.
*/
fn quadSwapDiagonal(e : T) -> T {}

/**
Returns the value of e from invocation in the quad sharing the same X dimension. That is:
* IDs 0 and 1 swap.
* IDs 2 and 3 swap.
*/
fn quadSwapX(e : T) -> T {}

/**
Returns the value of e from invocation in the quad sharing the same Y dimension. That is:
* IDs 0 and 2 swap.
* IDs 1 and 3 swap.
*/
fn quadSwapY(e : T) -> T {}
