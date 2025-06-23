package S02.RETO_02;
import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {

    private final String nombre; // Ej. "Sala de cirugía"
    private final ReentrantLock lock = new ReentrantLock(); //  Control de acceso

    public RecursoMedico(String nombre) {
        this.nombre = nombre;
    }

    // Simula el uso exclusivo del recurso por parte de un profesional
    public void usar(String profesional) {
        lock.lock(); // 🚪 Solicita acceso exclusivo
        try {
            System.out.println("👨‍️ " + profesional + " ha ingresado a " + nombre);
            Thread.sleep(1000); //  Simula el uso del recurso
            System.out.println("✅ " + profesional + " ha salido de " + nombre);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock(); //  Libera el recurso
        }
    }
}