public class Transposition {
    public static String encrypt(String plaintext, int numColumns)
    {
        String textWithoutSpaces="";
        double numberOfRows=0;
        String cipherText="";
        //Removing spaces from text

        for(int i = 0; i < plaintext.length();i++)
        {
            if(plaintext.charAt(i)!=' ')
            {
                textWithoutSpaces += plaintext.charAt(i);
            }
        }

        //System.out.print(textWithoutSpaces);

        //Calculating number of rows
        numberOfRows = textWithoutSpaces.length()/numColumns;

        if(textWithoutSpaces.length()% numColumns !=0)
        {
            //If there is a remainder when calculating the number of rows
            //round the number up
            numberOfRows = Math.ceil((double)textWithoutSpaces.length()/(double)numColumns);
        }

        //System.out.print("Number of Rows: " + numberOfRows);

        //Check if the number of letters will fit the grid
        //if not add in X's to fill the empty space
        if(textWithoutSpaces.length() != numColumns*numberOfRows)
        {
            for(int i = textWithoutSpaces.length(); i < numColumns*numberOfRows; i++)
            {
                textWithoutSpaces += "x";
            }
        }
        //System.out.print(textWithoutSpaces);

        //Create the cipher text message

        for(int col = 0;col < numColumns; col++)
        {
            int index = col;

            for(int row = 0; row < numberOfRows; row++)
            {
                cipherText = cipherText + textWithoutSpaces.charAt(index);
                index += numColumns;
            }
        }

        return cipherText;

    }

    public static String decrypt(String plaintext, int numColumns)
    {

        String originalText="";
        double numberOfRows = 0;
        //Calculate number of rows

        numberOfRows = plaintext.length()/numColumns;

        if(plaintext.length()% numColumns !=0)
        {
            //If there is a remainder when calculating the number of rows
            //round the number up
            numberOfRows = Math.ceil((double)plaintext.length()/(double)numColumns);
        }

        //Re organise the letters into original order
        for(int row = 0;row < numberOfRows; row++)
        {
            int index = row;

            for(int col = 0; col < numColumns; col++)
            {
                originalText = originalText + plaintext.charAt(index);
                index += numberOfRows;
            }
        }

        //System.out.print("\n" + originalText);

        return originalText;

    }
}
