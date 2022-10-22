import java.util.Scanner;

public class CajeroAutomatico {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String cardNum = "123456789"; // Número de tarjeta
        int pwd = 1235; // Contraseña
        boolean flag = true; // Declara una variable booleana
        double surplus = 1000;// Saldo inicial

        System.out.println("***********Bienvenido al cajero automático JLGA***********");

        for (int i = 1; i <= 3; i++) {
            System.out.println("\nPor favor inserte su tarjeta bancaria:");
            String inputCard = input.next();
            System.out.println("Por favor ingrese su contraseña:");
            int inputPwd = input.nextInt();

            // Autenticacion (Maximo 3 veces)
            if (inputCard.equals(cardNum) && inputPwd == pwd) {
                flag = true;
                break;
            } else {
                if (i <= 2) {
                    System.out.println("La contraseña es incorrecta, prueba nuevamente... ");
                } else {
                    System.out.println("Su tarjeta fue bloqueada por actividad sospechosa...");
                    break;
                }
                flag = false;
            }
        }

        if (flag) {
            char answer = 's';
            while (answer == 's') {
                System.out.println("Seleccione una función: 1. Retirar Saldo 2. Depósito 3. Consultar saldo 4. Transferencia 5. Salir");
                int choice = input.nextInt();
                switch (choice) {
                case 1:
                    // Realizar una operación de retirada
                    System.out.println("---> Retirada");
                    System.out.println("Ingrese el monto del retiro:");
                    double getMoney = input.nextDouble();
                    if (getMoney > 0) {
                        if (getMoney <= surplus) {
                            if (getMoney % 100 == 0) {
                                System.out.println("Toma tu dinero... El saldo es $" + (surplus - getMoney));
                            } else {
                                System.out.println("Lo siento, no puedo aceptar el dinero");
                            }
                        } else {
                            System.out.println("Lo siento, el saldo es insuficiente!");
                        }
                    } else {
                        System.out.println("Ingrese la cantidad correcta:");
                    }

                    break;
                case 2:
                    // Realiza la operación de depósito
                    System.out.println("---> Depósito");
                    System.out.println("Ingrese el dinero deseado:");
                    double saveMoney = input.nextDouble();
                    if (saveMoney > 0 && saveMoney <= 10000) {
                        if (saveMoney % 100 == 0) {
                            surplus += saveMoney;
                            System.out.println("¡Depósito exitoso! El saldo es $" + surplus);
                        } else {

                            double backMoney = saveMoney % 100;
                            surplus = saveMoney + surplus - backMoney;
                            System.out.println("¡Depósito exitoso! El saldo es $" + surplus);
                            System.out.println("Por favor, retire el dinero $" + backMoney);
                        }
                    } 
                    break;
                case 3:
                    // Ejecutar saldo de consulta
                    System.out.println("---> Consultar saldo");
                    System.out.println("El saldo de su tarjeta es:" + surplus);
                    break;
                case 4:
                    // Realiza la operación de transferencia
                    System.out.println("---> Transferencia");
                    System.out.println("Ingrese el monto de la transferencia:");
                    double goMoney = input.nextDouble(); // cantidad de transferencia
                    if (goMoney > 0) {
                        if (goMoney <= surplus) {
                            System.out.println("¡Transferencia exitosa! El dinero es $" + (surplus - goMoney));
                        } else {
                            System.out.println("Lo sentimos, asegúrate de tener suficiente saldo en la tarjeta");
                        }

                    } else {
                        System.out.println("Transferencia fallida, ingrese la cantidad correcta:");
                    }
                    break;
                case 5:;
                    System.out.println("Gracias por confiar en los cajeros JLGA");
                    return;
                default:
                    System.out.println("Lo sentimos, la función que seleccionó es incorrecta");
                    break;
                }
                System.out.println("¿Continuar? S / N");
                answer = input.next().charAt(0);

            } 
            System.out.println("Gracias por confiar en los cajeros JLGA");

        }

    }
}