struct Vertex {
	@builtin(position) pos: vec4f;
	xxx: mat4x4f
}

@vertex
fn vs_main(@builtin(vertex_index) in_vertex_index: u32) -> Vertex {
	let x = f32(1 - i32(in_vertex_index)) * 0.5;
	let y = f32(i32(in_vertex_index & 1u) * 2 - 1) * 0.5;
	return Vertex(vec4(x, y, 0.0, 1.0));
}

@fragment
fn fs_main(in: Vertex) -> @location(0) vec4f {
	return vec4(1.0, 0.0, 0.0, 1.0);
}

const pos = array(vec2f(0, -1), vec2f(1, -1), vec2f(0, 0), vec2f(1, 0));