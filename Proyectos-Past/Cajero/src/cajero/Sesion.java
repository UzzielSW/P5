package cajero;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ConcurrentHashMap;

public class Sesion extends Thread {

    private Socket client;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    ConcurrentHashMap usuarios;

    int numberC;

    public Sesion(Socket socket, int numberC, ConcurrentHashMap user) {
        client = socket;
        usuarios = user;
        this.numberC = numberC;

        try {
            in = new ObjectInputStream(client.getInputStream());
            out = new ObjectOutputStream(client.getOutputStream());
//            out.flush();
        } catch (IOException e) {
            System.out.println("Error en la apertura de flujos");
        }
    }

    @Override
    public void run() {

        sesion();
    }

    public void recibirDatos() {
//        try {
//            do {
//                Cuenta temp = (Cuenta) in.readObject();
////                st = (String) bufferDeEntrada.readUTF();
//
////                mostrarTexto("\n [Cliente] => " + temp.toString() + "");
//                System.out.println("\n Validando => " + temp.toString() + "");
//                if (usuarios.containsKey(temp.getClave())) {
//                    System.out.println("\n [Servidor] => El usuario inicio sesion");
//                } else {
//                    mostrarTexto("\n [Servidor] => El usuario no se encuentra registrado");
//                }
//
////            } while (!st.equals(COMANDO_TERMINACION));
//            } while (true);
//        } catch (IOException e) {
//            cerrarConexion();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

//        public void cerrarConexion() {
//        try {
////            bufferDeEntrada.close();
////            bufferDeSalida.close();
//            in.close();
//            out.close();
//            socket.close();
//        } catch (IOException e) {
//            mostrarTexto("Excepción en cerrarConexion(): " + e.getMessage());
//        } finally {
//            mostrarTexto("[Servidor] => Conversación finalizada....");
//            System.exit(0);
//        }
//    }
    public void sesion() {
        try {
            while (true) {
                Cuenta temp;

//                do {
                String option = (String) in.readObject();

                if (option.equals("Valida")) {

                    System.out.println("\nValidando cliente ingresado...");
                    temp = (Cuenta) in.readObject();
                    if (usuarios.containsKey(temp.getClave())) {
                        System.out.println("usuario encontrado");
                    } else {
                        System.out.println("no se encontro el usuario");
                    }
                }
//
//                    if (option.equals("nuevo Usuario")) {
//                        System.out.println("\ncreacion de nuevo usuario en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("proceso de registro Cancelado")) {
//                            System.out.println("\nregistro Cancelado\n");
//                        } else {
//
//                            System.out.println("\nRegistro en proceso\n");
//
//                            ObjectInputStream recieveRegisterData = new ObjectInputStream(client.getInputStream());
//
//                            String name = recieveRegisterData.readObject().toString();
//
//                            String lastName = recieveRegisterData.readObject().toString();
//
//                            String Id = recieveRegisterData.readObject().toString();
//
//                            String Password = recieveRegisterData.readObject().toString();
//
//                            String M = recieveRegisterData.readObject().toString();
//
//                            Cuenta addClient = new Cuenta(name, lastName, Id, Password);
//
//                            System.out.println("\nFin de Registro\n");
//
//                        }
//                    } /////////////////////////////////////////////////////////////////////
//                    else if (option.equals("iniciar Sesion")) {
//                        System.out.println("\nIniciando Sesion en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("inicio de sesion Cancelado")) {
//                            System.out.println("\nInicio de Sesion cancelado\n");
//                        } else
//					
//				try {
//
//                            ObjectInputStream recieveSesionData = new ObjectInputStream(client.getInputStream());
//
//                            String name = recieveSesionData.readObject().toString();
//
//                            String lastName = recieveSesionData.readObject().toString();
//
//                            sesionData = new Methods();
//
//                            sesionData.sesion(name, lastName);
//
//                            /////////////////////////////////////////////////////////
//                            ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
//
//                            String answer = sesionData.permitir;
//
//                            sendAnswer.writeObject(answer);
//
//                            if (answer.equals("si")) {
//                                ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                                String Id = sesionData.cedul;
//
//                                String m = sesionData.sald;
//
//                                sendData.writeObject(answer);
//
//                                sendData.writeObject(name);
//
//                                sendData.writeObject(lastName);
//
//                                sendData.writeObject(Id);
//
//                                sendData.writeObject(m);
//                            } else if (answer.equals("no")) {
//                                ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                                sendData.writeObject(answer);
//                            } else if (answer.equals("no hay clientes")) {
//                                ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                                sendData.writeObject(answer);
//                            }
//
//                        } catch (Exception e) {
//                        }
//
//                    } //////////////////////////////////////////////////////////////////////
//                    else if (option.equals("realizar un Deposito")) {
//                        System.out.println("Depositar en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("deposito Cancelado")) {
//                            System.out.println("\nDeposito cancelado\n");
//                        } else {
//
//                            ObjectInputStream recieveDeposit = new ObjectInputStream(client.getInputStream());
//
//                            String Deposit = recieveDeposit.readObject().toString();
//
//                            sesionData.Depositar(Deposit);
//
//                            ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
//
//                            sendAnswer.writeObject(sesionData.permitirDepo);
//
//                        }
//                    } //////////////////////////////////////////////////////////////////////
//                    else if (option.equals("realizar un Retiro")) {
//
//                        System.out.println("Retirar en proceso\n");
//
//                        ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
//
//                        String access = recieveAccess.readObject().toString();
//
//                        if (access.equals("retiro Cancelado")) {
//                            System.out.println("\nretiro Cancelado\n");
//                        } else {
//
//                            ObjectInputStream recieveWithdraw = new ObjectInputStream(client.getInputStream());
//
//                            String Withdraw = recieveWithdraw.readObject().toString();
//
//                            sesionData.Retirar(Withdraw);
//
//                            ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
//
//                            sendAnswer.writeObject(sesionData.permitirWith);
//
//                        }
//                    } else if (option.equals("Visualizar Clientes")) {
//                        System.out.println("\nVisualizacion de Clientes en proceso\n");
//
//                        ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
//
//                        LinkedList clientsList = new LinkedList();
//
//                        if (dataFile.exists()) {
//
//                            ObjectInputStream extract = new ObjectInputStream(new FileInputStream(new File("clientes.txt")));
//
//                            clientsList = (LinkedList) extract.readObject();
//
//                            sendData.writeObject(clientsList);
//
//                        } else {
//
//                            sendData.writeObject(clientsList);
//
//                        }
//                    } //////////////////////////////////////////////////////////////////////
//                    else if (option.equals("End Program !")) {
//                        System.out.println("\nFinalizando en proceso\n");
//
//                        try {
//
//                            Thread.sleep(2000);
//
//                        } catch (InterruptedException s) {
//                        }
//                    } else if (option.equals("Consultar Balance")) {
//                        System.out.println("\nConsulta de Balance en proceso\n");
//
//                        ObjectOutputStream sendactualBalance = new ObjectOutputStream(client.getOutputStream());
//
//                        sesionData.seeBalance();
//
//                        sendactualBalance.writeObject(sesionData.Balance);
//                    }
//
//                } while (!option.equals("salir"));
            }

        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception d) {
        }
    }
}
