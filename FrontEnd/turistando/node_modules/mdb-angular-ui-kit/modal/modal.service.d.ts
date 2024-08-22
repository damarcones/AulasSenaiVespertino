import { Overlay } from '@angular/cdk/overlay';
import { ComponentType } from '@angular/cdk/portal';
import { ComponentFactoryResolver, Injector, TemplateRef } from '@angular/core';
import { MdbModalConfig } from './modal-config';
import { MdbModalRef } from './modal-ref';
import * as i0 from "@angular/core";
export declare class MdbModalService {
    private _document;
    private _overlay;
    private _injector;
    private _cfr;
    constructor(_document: any, _overlay: Overlay, _injector: Injector, _cfr: ComponentFactoryResolver);
    open<T, D = any>(componentOrTemplateRef: ComponentType<T> | TemplateRef<T>, config?: MdbModalConfig<D>): MdbModalRef<T>;
    private _createOverlay;
    private _getOverlayConfig;
    private _createContainer;
    private _createContent;
    private _createInjector;
    private _registerListeners;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbModalService, never>;
    static ɵprov: i0.ɵɵInjectableDeclaration<MdbModalService>;
}
