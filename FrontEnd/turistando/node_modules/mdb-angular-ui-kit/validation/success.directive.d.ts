import { ElementRef, Renderer2, OnInit, OnDestroy } from '@angular/core';
import { Subject } from 'rxjs';
import * as i0 from "@angular/core";
export declare class MdbSuccessDirective implements OnInit, OnDestroy {
    private _elementRef;
    private renderer;
    id: string;
    successMsg: boolean;
    messageId: string;
    readonly _destroy$: Subject<void>;
    constructor(_elementRef: ElementRef, renderer: Renderer2);
    private _getClosestEl;
    ngOnInit(): void;
    ngOnDestroy(): void;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbSuccessDirective, never>;
    static ɵcmp: i0.ɵɵComponentDeclaration<MdbSuccessDirective, "mdb-success", never, { "id": { "alias": "id"; "required": false; }; }, {}, never, ["*"], false, never>;
}
