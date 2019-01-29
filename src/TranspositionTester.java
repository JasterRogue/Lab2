public class TranspositionTester {
    public static void main(String[] args)
    {
        String encryptedMessage = Transposition.encrypt("This is a secret message1",5);
        System.out.print(encryptedMessage);

        String decryptedMessage = Transposition.decrypt(encryptedMessage,5);
       // System.out.print("\n" + decryptedMessage);

    }
}
