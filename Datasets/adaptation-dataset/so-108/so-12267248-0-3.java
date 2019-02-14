public class foo {
@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    int desiredWidth = 100;
    int desiredHeight = 100;

    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

    int width;
    int height;

    //Measure Width
    if (widthMode == MeasureSpec.EXACTLY) {
        //Must be this size
        width = widthSize;
    } else if (widthMode == MeasureSpec.AT_MOST) {
        //Can't be bigger than...
        width = Math.min(desiredWidth, widthSize);
    } else {
        //Be whatever you want
        width = desiredWidth;
    }

    //Measure Height
    if (heightMode == MeasureSpec.EXACTLY) {
        //Must be this size
        height = heightSize;
    } else if (heightMode == MeasureSpec.AT_MOST) {
        //Can't be bigger than...
        height = Math.min(desiredHeight, heightSize);
    } else {
        //Be whatever you want
        height = desiredHeight;
    }

    //MUST CALL THIS
    setMeasuredDimension(width, height);
}
}