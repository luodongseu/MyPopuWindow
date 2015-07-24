# MyPopuWindow
自定义的PopuWindow<br>
可以实现简单的弹出框+动画+获得内容View

#使用方法
##1.编写弹出框的布局xml
<?xml version="1.0" encoding="utf-8"?>
/<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="#a0000000"
    android:orientation="vertical" >

    /<LinearLayout
        android:id="@+id/ly_content"
        android:layout_width="match_parent"
        android:layout_height="130dp"
        android:background="#f0efed"
        android:orientation="vertical"
        android:paddingLeft="15dp"
        android:paddingRight="15dp" >

       /<LinearLayout
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:orientation="horizontal" >

            /<CheckBox
                android:id="@+id/cb_bj"
                android:layout_width="0dp"
                android:layout_height="match_parent"
                android:layout_marginBottom="10dp"
                android:layout_marginLeft="15dp"
                android:layout_marginRight="15dp"
                android:layout_marginTop="10dp"
                android:layout_weight="1"
                android:background="@drawable/selector_ly_checkbox"
                android:button="@null"
                android:gravity="center"
                android:text="北京"
                android:textColor="#7d7d7d" />
##2.在Activity中应用
mPopWindow = new MPopWindow(MainActivity.this);<br>
		mPopWindow.setLayoutId(R.layout.index_popu);<br>
		mPopWindow.setWindow(WindowUtil.getWidth(), WindowUtil.getHeigt());<br>
		popContent = mPopWindow.getContentView();<br>
		mPopWindow.setViewStartAnimationId(<br>
						(LinearLayout) popContent.findViewById(R.id.ly_content),<br>
						R.anim.fade_in);<br>
				mPopWindow.showPopupWindow(tvCity);<br>//tvCity为你要显示的弹出框的父类，具体实现可参见源代码
