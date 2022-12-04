//+ old-global-constant-decl
const x: array<vec4, 10> = 1234;
@id(1) override x : i32;
let floop = 1234;

const INV_ATLAS_SIZE: f32 = 1.0 / 2048.0;

struct Vertex {
	@builtin(position) pos: vec4<f32>,
	boop: texture_2d_array<f32>,
	bloop: texture_2d<f32>,
}

fn foo() {
    let x: texture_2d_array<f32> = 1234;
    let x: texture_2d<f32> = 1234;
    let x: array<vec4, 10> = 1234;
}