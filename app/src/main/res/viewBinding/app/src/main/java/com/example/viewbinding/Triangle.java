package com.example.viewbinding;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Triangle {
    private final FloatBuffer vertexBuffer;
    private final FloatBuffer colorBuffer;
    private final ByteBuffer indexBuffer;

    private final float[] vertices = {
            -1.0f, -1.0f, -1.0f, //top
            1.0f, -1.0f, -1.0f, //left-bottom -back
            1.0f, -1.0f, 1.0f,//right-bottom -back
            -1.0f, -1.0f, 1.0f, //left-bottom- front
            0.0f, 1.0f, 0.0f //Top
    };

    private final float[] colors = {
            1.0f , 0.0f, 0.0f, 1.0f, //red
            0.0f , 1.0f , 0.0f , 1.0f, //green
            0.0f , 0.0f , 1.0f, 1.0f, //blue
            0.0f , 1.0f , 0.0f, 1.0f, //green
            1.0f , 0.0f , 0.0f, 1.0f //red
    };

    private final byte[] indices = {
            2 , 4 , 3, //frontface
            1 , 4 , 2, //rightback
            0 , 4 , 1, //backface
            4 , 0 , 3  //leftface

    };


    public Triangle() {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder()); // Use native byte order
        vertexBuffer = vbb.asFloatBuffer(); // Convert byte buffer to float
        vertexBuffer.put(vertices);         // Copy data into buffer
        vertexBuffer.position(0);

        // Setup color-array buffer. Colors in float. A float has 4 bytes (NEW)
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
        cbb.order(ByteOrder.nativeOrder()); // Use native byte order (NEW)
        colorBuffer = cbb.asFloatBuffer();  // Convert byte buffer to float (NEW)
        colorBuffer.put(colors);            // Copy data into buffer (NEW)
        colorBuffer.position(0);            // Rewind (NEW)


        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);

    }

    // Render this shape
    public void draw(GL10 gl) {
        gl.glFrontFace(GL10.GL_CCW);
//         Enable vertex-array and define the buffers
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);

        gl.glEnableClientState(GL10.GL_COLOR_ARRAY); //Enable color
        gl.glColorPointer(4,GL10.GL_FLOAT , 0 , colorBuffer);

        // Draw the primitives via index-array
        gl.glDrawElements(GL10.GL_TRIANGLES, indices.length, GL10.GL_UNSIGNED_BYTE, indexBuffer);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
    }
}
