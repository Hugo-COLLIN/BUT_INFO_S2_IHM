public class SerpentToString
{
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        //Ajout 1re ligne pointillee
        sb.append("-".repeat(nb_cases_largeur + 2) + "\n");

        for (int y = 0 ; y < nb_cases_hauteur ; y ++)
        {
            //ajout delimiteur debut
            sb.append("|");
            for (int x = 0 ; x < nb_cases_largeur ; x ++)
                sb.append(caractere_case(x,y));

            //Ajout delim fin
            sb.append("|");
            //Retour ligne
            sb.append("\n");
        }

        //Ajout ligne pointillee finale
        sb.append("-".repeat(nb_cases_largeur + 2) + "\n");

        return sb.toString();
    }


}
