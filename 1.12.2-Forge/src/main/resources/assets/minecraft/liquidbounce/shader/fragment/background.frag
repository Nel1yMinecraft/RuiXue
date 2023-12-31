uniform float iTime;
uniform vec2 iMouse;
uniform vec2 iResolution;

// Created by inigo quilez - iq/2013 : https://www.shadertoy.com/view/4dl3zn
// License Creative Commons Attribution-NonCommercial-ShareAlike 3.0 Unported License.
// Messed up by Weyland

void main( void )
{
	vec2 uv = -1.0 + 2.0*gl_FragCoord.xy / iResolution.xy;
	uv.x *=  iResolution.x / iResolution.y;

    // background	 
	vec3 color = vec3(1.0);

    // bubbles	
	for( int i=0; i<64; i++ )
	{
        // bubble seeds
		float pha =      sin(float(i)*546.13+1.0)*0.5 + 0.5;
		float siz = pow( sin(float(i)*651.74+5.0)*0.5 + 0.5, 4.0 );
		float pox =      sin(float(i)*321.55+4.1) * iResolution.x / iResolution.y;

        // buble size, position and color
		float rad = 0.1 + 0.5*siz+sin(iTime/6.+pha*500.0+siz)/20.0;
		vec2  pos = vec2( pox+sin(iTime/10.+pha+siz), -1.0-rad + (2.0+2.0*rad)
						 *mod(pha+0.1*(iTime/5.0)*(0.2+0.8*siz),1.0));
		float dis = length( uv - pos );
		vec3  col = mix( vec3(0.194*sin(iTime/6.0),0.3,0.0), 
						vec3(1.1*sin(iTime/9.0),0.4,0.8), 
						0.5+0.5*sin(float(i)*1.2+1.9));
        // render
		float f = length(uv-pos)/rad;
		f = sqrt(clamp(1.0+(sin((iTime/7.0)+pha*500.0+siz)*0.5)-f*f,0.0,1.0));
		color -= col.zyx *(1.0-smoothstep( rad*0.95, rad, dis )) * f;
	}
    
    // vigneting	
	//color *= sqrt(1.5-0.5*length(uv));
    
	gl_FragColor = vec4(color,1.0);
}
