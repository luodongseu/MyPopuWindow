import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.PopupWindow;

/**
 * 自定义popupWindow
 * 
 * 可单独设置背景出现的样式
 * 
 * @author ld
 * 
 * 
 */
public class MPopWindow extends PopupWindow {
	// 内容视图
	private View contentView;
	// Context
	private Context context;

	public MPopWindow(Context context) {
		this.context = context;
	}

	/**
	 * 设置弹出窗的宽度和高度
	 * 
	 * @param h
	 * @param l
	 */
	public void setWindow(int w, int h) {
		if (w != 0)
			this.setWidth(w);
		if (h != 0)
			this.setHeight(h);
		this.update();
	}

	/**
	 * 设置弹出框的内容
	 * 
	 * @param child
	 */
	public void setView(View child) {
		contentView = child;
		// 设置SelectPicPopupWindow的View
		this.setContentView(contentView);
		initView();
	}

	/**
	 * 获得内容视图
	 */
	public View getContentView() {
		return contentView;
	}

	private void initView() {
		// 设置SelectPicPopupWindow弹出窗体的宽
		this.setWidth(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		// 设置SelectPicPopupWindow弹出窗体可点击
		this.setFocusable(true);
		this.setOutsideTouchable(true);
		// 实例化一个ColorDrawable颜色为半透明
		ColorDrawable dw = new ColorDrawable(0000000000);
		// 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
		this.setBackgroundDrawable(dw);
		this.setAnimationStyle(0);
	}

	/**
	 * 设置弹出框的内容ID
	 * 
	 * @param layoutId
	 */
	@SuppressLint("InflateParams")
	public void setLayoutId(int layoutId) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		contentView = inflater.inflate(R.layout.index_popu, null);
		// 设置SelectPicPopupWindow的View
		this.setContentView(contentView);
		initView();
	}

	/**
	 * 设置整个弹出框的初始动画
	 * 
	 * @param animationId
	 */
	public void setContentAnimationStyleId(int animationId) {
		// 设置PopupWindow弹出窗体动画效果
		this.setAnimationStyle(animationId);
		// 如果无动画，可传0
		// this.setAnimationStyle(0);
		// this.setAnimationStyle(R.style.AnimationPreview);
	}

	/**
	 * 设置弹出框内的某个控件的开始动画
	 * 
	 * @param v
	 * @param animationId
	 */
	public void setViewStartAnimationId(ViewGroup v, int animationId) {
		// 通过加载XML动画设置文件来创建一个Animation对象；
		Animation animation = AnimationUtils
				.loadAnimation(context, animationId);
		// 得到一个LayoutAnimationController对象；
		LayoutAnimationController lac = new LayoutAnimationController(animation);
		// 设置控件显示的顺序；
		lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
		// 设置控件显示间隔时间；
		lac.setDelay(1);
		// 为ListView设置LayoutAnimationController属性；
		v.setLayoutAnimation(lac);
		// 刷新状态
		this.update();
	}

	/**
	 * 显示popupWindow
	 * 
	 * @param parent
	 */
	public void showPopupWindow(View parent) {
		if (!this.isShowing()) {
			// 以下拉方式显示popupwindow
			this.showAsDropDown(parent, 0, 0);
		} else {
			this.dismiss();
		}

	}
}
