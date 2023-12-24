package pishing;
import java.io.*;
import java.util.*;

public class pishing {
	private static final Map<String, Integer> phishingTerms = new HashMap<>();
	static {
        phishingTerms.put("paypal", 3);
        phishingTerms.put("phishing", 3);
        phishingTerms.put("contraseña", 3);
        phishingTerms.put("actualización de seguridad", 2);
        phishingTerms.put("oferta especial", 2);
        phishingTerms.put("ganador de premio", 2);
        phishingTerms.put("urgente", 3);
        phishingTerms.put("tarjeta de credito", 2);
        phishingTerms.put("restablecimiento de contraseña", 2);
        phishingTerms.put("soporte técnico", 2);
        phishingTerms.put("seguridad de la cuenta", 2);
        phishingTerms.put("procesamiento de pago", 2);
        phishingTerms.put("confirmación de pedido", 2);
        phishingTerms.put("promoción", 2);
        phishingTerms.put("descuento", 2);
        phishingTerms.put("banca en línea", 3);
        phishingTerms.put("compra sospechosa", 2);
        phishingTerms.put("verificación de identidad", 2);
        phishingTerms.put("recuperación de cuenta", 2);
        phishingTerms.put("banco", 3);
        phishingTerms.put("correo electronico", 3);
        phishingTerms.put("fraude", 3);
        phishingTerms.put("spam", 2);
        phishingTerms.put("problema de facturación", 2);
        phishingTerms.put("cuenta suspendida", 2);
        phishingTerms.put("microsoft", 3);
        phishingTerms.put("google", 3);
        phishingTerms.put("msj txt", 3);
        phishingTerms.put("facebook", 3);
        phishingTerms.put("apple", 3);
    }


public static void main(String[] args) {
    String fileName = "C:\\Users\\Downloads\\anime.txt"; 

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        String line;
        int totalScore = 0;
        Map<String, Integer> termOccurrences = new HashMap<>();

        while ((line = reader.readLine()) != null) {
            for (String term : phishingTerms.keySet()) {
                if (line.toLowerCase().contains(term.toLowerCase())) {
                    totalScore += phishingTerms.get(term);
                    termOccurrences.put(term, termOccurrences.getOrDefault(term, 0) + 1);
                }
            }
        }
        for (String term : termOccurrences.keySet()) {
            System.out.println("Término: " + term + ", Ocurrencias: " + termOccurrences.get(term) + ", Puntos: " + termOccurrences.get(term) * phishingTerms.get(term));
        }
        System.out.println("La puntuación total de phishing es: " + totalScore);

    } catch (IOException e) {
        e.printStackTrace();
    }
}
}