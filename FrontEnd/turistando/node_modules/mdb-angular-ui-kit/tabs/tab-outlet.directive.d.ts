import { CdkPortalOutlet } from '@angular/cdk/portal';
import { ComponentFactoryResolver, OnDestroy, OnInit, ViewContainerRef } from '@angular/core';
import { Subject } from 'rxjs';
import { MdbTabComponent } from './tab.component';
import * as i0 from "@angular/core";
export declare class MdbTabPortalOutlet extends CdkPortalOutlet implements OnInit, OnDestroy {
    readonly _destroy$: Subject<void>;
    tab: MdbTabComponent;
    constructor(_cfr: ComponentFactoryResolver, _vcr: ViewContainerRef, _document: any);
    ngOnInit(): void;
    ngOnDestroy(): void;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbTabPortalOutlet, never>;
    static ɵdir: i0.ɵɵDirectiveDeclaration<MdbTabPortalOutlet, "[mdbTabPortalOutlet]", never, { "tab": { "alias": "tab"; "required": false; }; }, {}, never, never, false, never>;
}
