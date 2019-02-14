public class foo {
private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec,
                               int heightSpec, int[] measuredDimension) {
    View view = recycler.getViewForPosition(position);
    recycler.bindViewToPosition(view, position);
    if (view != null) {
        RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
        int childWidthSpec = ViewGroup.getChildMeasureSpec(widthSpec,
                getPaddingLeft() + getPaddingRight(), p.width);
        int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
                getPaddingTop() + getPaddingBottom(), p.height);
        view.measure(childWidthSpec, childHeightSpec);
        measuredDimension[0] = view.getMeasuredWidth() + p.leftMargin + p.rightMargin;
        measuredDimension[1] = view.getMeasuredHeight() + p.bottomMargin + p.topMargin;
        recycler.recycleView(view);
    }
}
}