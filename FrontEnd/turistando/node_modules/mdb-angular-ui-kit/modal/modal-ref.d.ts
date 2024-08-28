import { OverlayRef } from '@angular/cdk/overlay';
import { Observable } from 'rxjs';
import { MdbModalContainerComponent } from './modal-container.component';
export declare class MdbModalRef<T> {
    protected _overlayRef: OverlayRef;
    private _container;
    constructor(_overlayRef: OverlayRef, _container: MdbModalContainerComponent);
    component: T;
    private readonly onClose$;
    readonly onClose: Observable<any>;
    close(message?: any): void;
}
