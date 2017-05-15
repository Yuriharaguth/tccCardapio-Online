package br.edu.ifpr._util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ByteImagem {
	
	public static byte[] convertImgToByte(String caminho){
		
		try {
			BufferedImage imagem = ImageIO.read(new File(caminho.toString()));   // crio a imagem
			ByteArrayOutputStream arrayBytes = new ByteArrayOutputStream();   // crio um OS de array de bytes
			ImageIO.write(imagem, "jpg", arrayBytes);   // Uso o write pra escrever os dados da imagem no OS do array de bytes
			return arrayBytes.toByteArray();	// Passando retorno para salvar em banco!
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas na conversão da imagem para o banco de dados!");
			e.printStackTrace();
			return null;
		}
		
	}

	//APENAS PARA VALIDAÇÃO DA CONVERSÃO!!
	public static void convertByteToImg(byte[] arrayBytes){	 
		try {
			BufferedImage img = null;
			img = ImageIO.read(new ByteArrayInputStream(arrayBytes));
			ImageIO.write(img, "JPG", new File("C:/TESTE/h.JPG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


/* DICA DO DANIEL
	ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
// Base64 em vetor de bytes
byte[] byteArray = byteArrayOutputStream .toByteArray();
// Base64 em String
String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);
 */