package com.example.viewbinding;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.opengles.GL10;

public class MyGLRenderer implements GLSurfaceView.Renderer {

    int currentTextureFilter = 0;  // Texture filter (NEW)
    Context context;
    Triangle triangle ;
    Square quard;



    // For controlling cube's z-position, x and y angles and speeds (NEW)
    float angleX = 0;   // (NEW)
    float angleY = 0;   // (NEW)
    float speedX = 0;   // (NEW)
    float speedY = 0;   // (NEW)
    float z = -6.0f;    // (NEW)


    boolean lightingEnabled = false;   // Is lighting on? (NEW)
    private final float[] lightAmbient = {0.5f, 0.5f, 0.5f, 1.0f};
    private final float[] lightDiffuse = {1.0f, 1.0f, 1.0f, 1.0f};
    private final float[] lightPosition = {0.0f, 0.0f, 2.0f, 1.0f};

    private static final float angleCube = 0;     // rotational angle in degree for cube
    private static final float speedCube = -1.5f; // rotational speed for cube




    //rotaional angle and speed
    private static final float angleTriangle = 0; //Rotational angle in dgree for paramid;
    private static final float angleQuad = 0;     //Rotational angle in dgree for cube
    private static final float speedTriangle = 0.2f; //Rotational angle in speed for paramid
    private static final float speedQuad = -1.5f;  //Rotational angle in speed for cube


    boolean blendingEnabled = false;  // Is blending on? (NEW)


    public MyGLRenderer(Context context) { //Constructor
        this.context = context;
        triangle = new Triangle();
        quard = new Square();
    }


    @Override
    public void onSurfaceCreated(GL10 gl, javax.microedition.khronos.egl.EGLConfig config) {

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);    // The type of depth testing to do
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);  // nice perspective view
        gl.glShadeModel(GL10.GL_SMOOTH);   // Enable smooth shading of color
        gl.glDisable(GL10.GL_DITHER);


        // Setup Texture, each time the surface is created (NEW)

//        ----------open this when cude is open
        quard.loadTexture(gl, context);    // Load image into Texture (NEW)
        gl.glEnable(GL10.GL_TEXTURE_2D);  // Enable texture (NEW)


        // Setup lighting GL_LIGHT1 with ambient and diffuse lights (NEW)
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_AMBIENT, lightAmbient, 0);
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_DIFFUSE, lightDiffuse, 0);
        gl.glLightfv(GL10.GL_LIGHT1, GL10.GL_POSITION, lightPosition, 0);
        gl.glEnable(GL10.GL_LIGHT1);   // Enable Light 1 (NEW)
        gl.glEnable(GL10.GL_LIGHT0);   // Enable the default Light 0 (NEW)

        //setup Blending
        gl.glColor4f(1.0f, 1.0f, 1.0f, 0.5f);           // Full brightness, 50% alpha (NEW)
        gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE); // Select blending function
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0) height = 1;
        float aspect = (float) width / height;

        // Set the viewport (display area) to cover the entire window
        gl.glViewport(0, 0, width, height);

        // Setup perspective projection, with aspect ratio matches viewport
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        //use prespective projection
        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);


        gl.glMatrixMode(GL10.GL_MODELVIEW); // Select model-view matrix
        gl.glLoadIdentity();

    }

    // Call back to draw the current frame.

    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);


        //Enable The Lightning
        if (lightingEnabled) {
            gl.glEnable(GL10.GL_LIGHTING);
        } else {
            gl.glDisable(GL10.GL_LIGHTING);
        }

        // Blending Enabled? (NEW)
        if (blendingEnabled) {
            gl.glEnable(GL10.GL_BLEND);       // Turn blending on (NEW)
            gl.glDisable(GL10.GL_DEPTH_TEST); // Turn depth testing off (NEW)

        } else {
            gl.glDisable(GL10.GL_BLEND);      // Turn blending off (NEW)
            gl.glEnable(GL10.GL_DEPTH_TEST);  // Turn depth testing on (NEW)
        }


        //--------Render the paramid ----------
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f,0.0f,-6.0f);
        gl.glRotatef(angleTriangle, 0.0f, 1.0f , 0.0f); //rotate the triangle with y - axis
        triangle.draw(gl);
        // You OpenGL|ES rendering code here




        //---------Rendering the color Cube

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, z);   // Translate into the screen (NEW)
        gl.glRotatef(angleX, 1.0f, 0.0f, 0.0f); // Rotate (NEW)
        gl.glRotatef(angleY, 0.0f, 1.0f, 0.0f); // Rotate (NEW)

        quard.draw(gl, currentTextureFilter);
//        // Update the rotational angle after each refresh (NEW)
//        angleTriangle += speedTriangle; // (NEW)
//        angleQuad += speedQuad;         // (NEW)

        angleX += speedX;  // (NEW)
        angleY += speedY;
    }
}
