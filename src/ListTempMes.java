import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ListTempMes {
    public static void main(String[] args) {
        TemperaturaMes tm = new TemperaturaMes();
        List<TemperaturaMes> ltm = new ArrayList<>();
        double mediaTemp, soma=0;
        int x;
        for (x=1; x <= 6; x++){
            switch (x){
                case 1: tm.setMes("Janeiro"); break;
                case 2: tm.setMes("Fevereiro"); break;
                case 3: tm.setMes("Março"); break;
                case 4: tm.setMes("Abril"); break;
                case 5: tm.setMes("Maio"); break;
                case 6: tm.setMes("Junho"); break;
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Digite a temperatura média de " + tm.getMes() + ": " );
            tm.setTemperatura(sc.nextDouble());
            soma += tm.getTemperatura();
            tm.setId(x);
            ltm.add(tm);
            System.out.println(ltm);
        }
        System.out.println(ltm.stream().count() + " Objetos na lista.");
        mediaTemp = soma/ltm.stream().count();
        for (TemperaturaMes tempMes : ltm) {
            System.out.println(tempMes.toString());
            if(tempMes.getTemperatura() > mediaTemp){
                System.out.println(tempMes.getId()+"- "+tempMes.getMes()+" - "
                        + tempMes.getTemperatura() + "ºC.");
            }
        }
    }
}

class TemperaturaMes {
    private int id;
    private String mes;
    private double temperatura;

    @Override
    public String toString() {
        return "TemperaturaMes{" +
                "id=" + id +
                ", mes='" + mes + '\'' +
                ", temperatura=" + temperatura +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getMes() {
        return mes;
    }

    public double getTemperatura() { return temperatura; }

    public void setId(int id) {
        this.id = id;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}
