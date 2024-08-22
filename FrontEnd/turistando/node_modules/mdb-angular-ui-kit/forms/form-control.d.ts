import { Observable } from 'rxjs';
import * as i0 from "@angular/core";
export declare abstract class MdbAbstractFormControl<T> {
    readonly stateChanges: Observable<void>;
    readonly input: HTMLInputElement;
    readonly labelActive: boolean;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbAbstractFormControl<any>, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbAbstractFormControl<any>, never, never, {}, {}, never, never, false, never>;
}
