import { ViewContainerRef } from '@angular/core';
export declare class MdbModalConfig<D = any> {
    animation?: boolean;
    backdrop?: boolean;
    ignoreBackdropClick?: boolean;
    keyboard?: boolean;
    modalClass?: string;
    containerClass?: string;
    viewContainerRef?: ViewContainerRef;
    data?: D | null;
    nonInvasive?: boolean;
}
