struct VertexOutput {
    @location(0) tex_coord: vec2<f32>,
    @builtin(position) position: vec4<f32>
}

// The uniform structure
struct Locals {
    transform: mat4x4<f32>
}

@group(0), @binding(0)
var<uniform> r_locals: Locals;

/**
 * The mighty vertex shader
 * @param position
 * @param tex_coord
 * @return transformed vertex
 */
@vertex
fn vs_main(@location(0) position: vec4<f32>, @location(1) tex_coord: vec2<f32>) -> VertexOutput {
    var vout: VertexOutput;
    vout.tex_coord = tex_coord;
    vout.position = r_locals.transform * position;
    return vout;
}

@group(0), @binding(1)
var r_color: texture_2d<u32>;

/*
  A simple fragment shader
 */
@fragment
fn fs_main(vin: VertexOutput) -> @location(0) vec4<f32> {
    let tex = textureLoad(r_color, vec2<i32>(vin.tex_coord * 256.0), 0);
    let v = f32(tex.x) / 255.0;
    return vec4<f32>(1.0 - (v * 5.0), 1.0 - (v * 15.0), 1.0 - (v * 50.0), 1.0);
}
