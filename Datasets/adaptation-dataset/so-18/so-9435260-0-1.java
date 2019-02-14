public class foo {
private void sharedConstructing(final Context context) {
    super.setClickable(true);
    this.context = context;
    mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
    matrix.setTranslate(1f, 1f);
    m = new float[9];
    setImageMatrix(matrix);
    setScaleType(ScaleType.MATRIX);

    setOnTouchListener(new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            mScaleDetector.onTouchEvent(event);


            matrix.getValues(m);
            float x = m[Matrix.MTRANS_X];
            float y = m[Matrix.MTRANS_Y];
            PointF curr = new PointF(event.getX(), event.getY());

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:

                     last.set(event.getX(), event.getY());
                        start.set(last);    
                    if (minScale < saveScale){

                    mode = DRAG;

                    Toast msg = Toast.makeText(context, "Drag mode", Toast.LENGTH_SHORT);

                     msg.show();
                  //   msg1.show();
                    }

                    break;

                case MotionEvent.ACTION_MOVE:
                    if (mode == DRAG) {
                        float deltaX = curr.x - last.x;
                        float deltaY = curr.y - last.y;
                        float scaleWidth = Math.round(origWidth * saveScale);
                        float scaleHeight = Math.round(origHeight * saveScale);
                        if (scaleWidth < width) {
                            deltaX = 0;
                            if (y + deltaY > 0)
                                deltaY = -y;
                            else if (y + deltaY < -bottom)
                                deltaY = -(y + bottom); 
                        } else if (scaleHeight < height) {
                            deltaY = 0;
                            if (x + deltaX > 0)
                                deltaX = -x;
                            else if (x + deltaX < -right)
                                deltaX = -(x + right);
                        } else {
                            if (x + deltaX > 0)
                                deltaX = -x;
                            else if (x + deltaX < -right)
                                deltaX = -(x + right);

                            if (y + deltaY > 0)
                                deltaY = -y;
                            else if (y + deltaY < -bottom)
                                deltaY = -(y + bottom);
                        }
                        matrix.postTranslate(deltaX, deltaY);
                        last.set(curr.x, curr.y);

                    }

                    break;

                case MotionEvent.ACTION_UP:
                    mode = NONE;
                    int xDiff = (int) Math.abs(curr.x - start.x);
                    int yDiff = (int) Math.abs(curr.y - start.y);

                     if (saveScale==minScale && (start.x-curr.x) > SWIPE_MIN_DISTANCE )
                    {
                    GestureDetector gestureDetector = new GestureDetector(new GestureListener());  
                        mode = FLING;
                        Toast msg2 = Toast.makeText(context, "Fling mode left to right", Toast.LENGTH_SHORT);

                         msg2.show();

                    }
                    else if (saveScale==minScale && (curr.x-start.x) > SWIPE_MIN_DISTANCE){
                        mode = FLING;
                        GestureDetector gestureDetector = new GestureDetector(new GestureListener());  
                        Toast msg2 = Toast.makeText(context, "Fling mode right to left", Toast.LENGTH_SHORT);

                         msg2.show();
                    }
                    if (xDiff < CLICK && yDiff < CLICK)
                        performClick();
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    mode = NONE;
                    break;
            }
            setImageMatrix(matrix);
            invalidate();
            return true; // indicate event was handled
        }



    });
}
}