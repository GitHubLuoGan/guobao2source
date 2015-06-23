#ifdef GL_ES 
precision mediump float; 
#endif 
varying MEDP vec2 uvVarying;
uniform sampler2D sampler;
uniform float weight;
void main()
{ 
	vec4 clr = texture2D ( sampler, uvVarying );
	float grey = dot(clr.rgb, vec3(0.299, 0.587, 0.114)); 
	float r = grey + (clr.r - grey) * weight;
	float g = grey + (clr.g - grey) * weight;
	float b = grey + (clr.b - grey) * weight;
	gl_FragColor = vec4(r, g, b, clr.a);
}