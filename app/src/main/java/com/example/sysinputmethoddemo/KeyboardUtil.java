package com.example.sysinputmethoddemo;

import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.inputmethodservice.KeyboardView.OnKeyboardActionListener;

public class KeyboardUtil {

	private KeyboardView keyboardView;
	private MyImeService myImeService;
	private Keyboard k1;// 字母键盘

	public KeyboardUtil(MyImeService myImeService1, KeyboardView keyboardView1) {
		super();
		keyboardView = keyboardView1;
		keyboardView.setOnKeyboardActionListener(listener);
		myImeService = myImeService1;
		k1 = new Keyboard(myImeService.getApplicationContext(), R.xml.qwerty);
		keyboardView.setKeyboard(k1);
		keyboardView.setEnabled(true);
		keyboardView.setPreviewEnabled(true);
	}

	private OnKeyboardActionListener listener = new OnKeyboardActionListener() {

		@Override
		public void swipeUp() {
		}

		@Override
		public void swipeRight() {
		}

		@Override
		public void swipeLeft() {
		}

		@Override
		public void swipeDown() {
		}

		@Override
		public void onText(CharSequence text) {
		}

		@Override
		public void onRelease(int primaryCode) {
		}

		@Override
		public void onPress(int primaryCode) {
		}

		@Override
		public void onKey(int primaryCode, int[] keyCodes) {
			switch (primaryCode) {
			case Keyboard.KEYCODE_DELETE:
				myImeService.deleteText();
				break;
			case Keyboard.KEYCODE_CANCEL:
				myImeService.hideInputMethod();
				break;
			default:
				myImeService.commitText(Character.toString((char) primaryCode));
				break;
			}
		}
	};

}
