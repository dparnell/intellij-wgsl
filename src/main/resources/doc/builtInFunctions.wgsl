/**
Returns the absolute value of e (e.g. e with a positive sign bit). Component-wise when T is a vector. (GLSLstd450Fabs)

* T is `f32` or `vecN<f32>`
*/
fn abs(e: T) -> T {
}

/**
Returns the arc cosine of e. Component-wise when T is a vector. (GLSLstd450Acos)

* T is `f32` or `vecN<f32>`
*/
fn acos(e: T) -> T {
}

/**
Returns the arc sine of e. Component-wise when T is a vector. (GLSLstd450Asin)

* T is `f32` or `vecN<f32>`
*/
fn asin(e: T) -> T {
}

/**
Returns the arc tangent of e. Component-wise when T is a vector. (GLSLstd450Atan)

* T is `f32` or `vecN<f32>`
*/
fn atan(e: T) -> T {
}

/**
Returns the arc tangent of e1 over e2. Component-wise when T is a vector. (GLSLstd450Atan2)

* T is `f32` or `vecN<f32>`
*/
fn atan2(e1: T, e2: T) -> T {
}

/**
Returns the ceiling of e. Component-wise when T is a vector. (GLSLstd450Ceil)

* T is `f32` or `vecN<f32>`
*/
fn ceil(e: T) -> T {
}

/**
Returns `min(max(e1,e2),e3)`. Component-wise when T is a vector. (GLSLstd450NClamp)

* T is `f32` or `vecN<f32>`
*/
fn clamp(e1: T, e2: T, e3: T) -> T {
}

/**
Returns the cosine of e. Component-wise when T is a vector. (GLSLstd450Cos)

* T is `f32` or `vecN<f32>`
*/
fn cos(e: T) -> T {
}

/**
Returns the hyperbolic cosine of e. Component-wise when T is a vector (GLSLstd450Cosh)

* T is `f32` or `vecN<f32>`
*/
fn cosh(e: T) -> T {
}

/**
Returns the cross product of e1 and e2. (GLSLstd450Cross)

* T is `f32`
*/
fn cross(e1: vec3<T>, e2: vec3<T>) -> vec3<T> {
}

/**
Converts radians to degrees, approximating e1 × 180 ÷ π. Component-wise when T is a vector
(GLSLstd450Degrees)

* T is `f32` or `vecN<f32>`
*/
fn degrees(e1: T) -> T {
}

/**
Returns the distance between e1 and e2 (e.g. `length(e1-e2)`). (GLSLstd450Distance)

* T is `f32` or `vecN<f32>`
*/
fn distance(e1: T, e2: T) -> f32 {
}

/**
Returns the natural exponentiation of e1 (e.g. e<sup>e1</sup>). Component-wise when T is a vector. (GLSLstd450Exp)

* T is `f32` or `vecN<f32>`
*/
fn exp(e1: T) -> T {
}

/**
Returns 2 raised to the power e (e.g. 2<sup>e</sup>). Component-wise when T is a vector. (GLSLstd450Exp2)

* T is `f32` or `vecN<f32>`
*/
fn exp2(e: T) -> T {
}

/**
Returns e1 if `dot(e2,e3)` is negative, and -e1 otherwise. (GLSLstd450FaceForward)

* T is `vecN<f32>`
*/
fn faceForward(e1: T, e2: T, e3: T) -> T {
}

/**
Returns the floor of e. Component-wise when T is a vector. (GLSLstd450Floor)

* T is `f32` or `vecN<f32>`
*/
fn floor(e: T) -> T {
}

/**
Returns `e1 * e2 + e3`. Component-wise when T is a vector. (GLSLstd450Fma)

* T is `f32` or `vecN<f32>`
*/
fn fma(e1: T, e2: T, e3: T) -> T {
}

/**
Returns the fractional bits of e (e.g. `e - floor(e)`). Component-wise when T is a vector. (GLSLstd450Fract)

* T is `f32` or `vecN<f32>`
*/
fn fract(e: T) -> T {
}

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
*/
fn frexp(e:T) -> __frexp_result {
}

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
*/
fn frexp(e:T) -> __frexp_result_vecN {
}

/**
Returns the reciprocal of sqrt(e). Component-wise when T is a vector. (GLSLstd450InverseSqrt)

* T is `f32` or `vecN<f32>`
*/
fn inverseSqrt(e: T) -> T {
}

/**
Returns e1 * 2<sup>e2</sup>. Component-wise when T is a vector. (GLSLstd450Ldexp)

* T is `f32` or `vecN<f32>`
* I is `i32` or `vecN<i32>`, where I is a scalar if T is a scalar, or a vector when T is a vector
*/
fn ldexp(e1: T, e2: I) -> T {
}

/**
Returns the length of e (e.g. abs(e) if T is a scalar, or sqrt(e[0]<sup>2</sup> + e[1]<sup>2</sup> + ...) if T is a vector). (GLSLstd450Length)

* T is `f32` or `vecN<f32>`
*/
fn length(e: T) -> f32 {
}

/**
Returns the natural logarithm of e. Component-wise when T is a vector. (GLSLstd450Log)

T is f32 or vecN<f32>
*/
fn log(e: T) -> T {
}

/**
Returns the base-2 logarithm of e. Component-wise when T is a vector. (GLSLstd450Log2)

* T is `f32` or `vecN<f32>`
*/
fn log2(e: T) -> T {
}

/**
Returns e2 if e1 is less than e2, and e1 otherwise. If one operand is a NaN, the other is returned. If both operands are NaNs, a NaN is returned. Component-wise when T is a vector. (GLSLstd450NMax)

* T is `f32` or `vecN<f32>`
*/
fn max(e1: T, e2: T) -> T {
}

/**
Returns e2 if e2 is less than e1, and e1 otherwise. If one operand is a NaN, the other is returned. If both operands are NaNs, a NaN is returned. Component-wise when T is a vector. (GLSLstd450NMin)

* T is `f32` or `vecN<f32>`
*/
fn min(e1: T, e2: T) -> T {
}

/**
Returns the linear blend of e1 and e2 (e.g. e1*(1-e3)+e2*e3). Component-wise when T is a vector.
(GLSLstd450FMix)

* T is `f32` or `vecN<f32>`
*/
fn mix(e1: T, e2: T,e3: T) -> T {
}

/**
Returns the component-wise linear blend of e1 and e2, using scalar blending factor e3 for each component.
Same as `mix(e1,e2,T(e3))`.

* T is `vecN<f32>`
*/
fn mix(e1: T ,e2: T ,e3: f32 ) -> T {
}

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
*/
fn modf(e:T) -> __modf_result {
}

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
*/
fn modf(e:T) -> __modf_result_vecN {
}

/**
Returns a unit vector in the same direction as e. (GLSLstd450Normalize)

* T is `f32`
*/
fn normalize(e: vecN<T>) -> vecN<T> {
}

/**
Returns e1 raised to the power e2. Component-wise when T is a vector. (GLSLstd450Pow)

* T is `f32` or `vecN<f32>`
*/
fn pow(e1: T, e2: T) -> T {
}

/**
Quantizes a 32-bit floating point value e as if e were converted to a IEEE 754 binary16 value, and then converted back to a IEEE 754 binary32 value.

Component-wise when T is a vector.
Note: The vec2<f32> case is the same as unpack2x16float(pack2x16float(e)).

(OpQuantizeToF16)

* T is `f32` or `vecN<f32>`
*/
fn quantizeToF16(e: T) -> T {
}

/**
Converts degrees to radians, approximating e1 × π ÷ 180. Component-wise when T is a vector
(GLSLstd450Radians)

* T is `f32` or `vecN<f32>`
*/
fn radians(e1: T) -> T {
}

/**
For the incident vector e1 and surface orientation e2, returns the reflection direction e1-2*dot(e2,e1)*e2. (GLSLstd450Reflect)

T is `vecN<f32>`
*/
fn reflect(e1: T, e2: T) -> T {
}

/**
For the incident vector e1 and surface normal e2, and the ratio of indices of refraction e3, let k = 1.0 -e3*e3* (1.0 - dot(e2,e1) * dot(e2,e1)). If k < 0.0, returns the refraction vector 0.0, otherwise return the refraction vector e3*e1- (e3* dot(e2,e1) + sqrt(k)) *e2. (GLSLstd450Refract)

* T is `vecN<f32>`
* I is `f32`
*/
fn refract(e1: T, e2: T, e3: I) -> T {
}

/**
Result is the integer k nearest to e, as a floating point value.
When e lies halfway between integers k and k+1, the result is k when k is even, and k+1 when k is odd.
Component-wise when T is a vector. (GLSLstd450RoundEven)

* T is `f32` or `vecN<f32>`
*/
fn round(e: T) -> T {
}

/**
Returns the sign of e. Component-wise when T is a vector. (GLSLstd450FSign)

* T is `f32` or `vecN<f32>`
*/
fn sign(e: T) -> T {
}

/**
Returns the sine of e. Component-wise when T is a vector. (GLSLstd450Sin)

* T is `f32` or `vecN<f32>`
*/
fn sin(e: T) -> T {
}

/**
Returns the hyperbolic sine of e. Component-wise when T is a vector. (GLSLstd450Sinh)

* T is `f32` or `vecN<f32>`
*/
fn sinh(e: T) -> T {
}

/**
Returns the smooth Hermite interpolation between 0 and 1. Component-wise when T is a vector. (GLSLstd450SmoothStep)

* T is `f32` or `vecN<f32>`
*/
fn smoothStep(e1: T, e2: T, e3: T) -> T {
}

/**
Returns the square root of e. Component-wise when T is a vector. (GLSLstd450Sqrt)

* T is `f32` or `vecN<f32>`
*/
fn sqrt(e: T) -> T {
}

/**
Returns 0.0 if e1 is less than e2, and 1.0 otherwise. Component-wise when T is a vector. (GLSLstd450Step)

* T is `f32` or `vecN<f32>`
*/
fn step(e1: T, e2: T) -> T {
}

/**
Returns the tangent of e. Component-wise when T is a vector. (GLSLstd450Tan)

* T is `f32` or `vecN<f32>`
*/
fn tan(e: T) -> T {
}

/**
Returns the hyperbolic tangent of e. Component-wise when T is a vector. (GLSLstd450Tanh)

* T is `f32` or `vecN<f32>`
*/
fn tanh(e: T) -> T {
}

/**
Returns the nearest whole number whose absolute value is less than or equal to e. Component-wise when T is a vector. (GLSLstd450Trunc)

* T is `f32` or `vecN<f32>`
*/
fn trunc(e: T) -> T {
}
