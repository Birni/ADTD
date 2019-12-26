package services.VO;

import services.entity.Transporter;

public class ITransporter<T> {
    public final int index;
    public final T object;

    public ITransporter(int index, T object) {
        this.index = index;
        this.object = object;
    }
}