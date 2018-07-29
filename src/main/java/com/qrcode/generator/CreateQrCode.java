package com.qrcode.generator;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;

public class CreateQrCode {

	public static void main(String... args) {
		ByteArrayOutputStream bout = QRCode.from("01234567898").withSize(250, 250).to(ImageType.PNG).stream();
		
		try {
			OutputStream out = new FileOutputStream("tmp/qr-code.png");
			bout.writeTo(out);
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
