import { ElementRef } from '@angular/core';
import * as i0 from "@angular/core";
export declare class MdbCarouselItemComponent {
    private _elementRef;
    interval: number | null;
    carouselItem: boolean;
    active: boolean;
    next: boolean;
    prev: boolean;
    start: boolean;
    end: boolean;
    get host(): HTMLElement;
    constructor(_elementRef: ElementRef);
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbCarouselItemComponent, never>;
    static ɵcmp: i0.ɵɵComponentDeclaration<MdbCarouselItemComponent, "mdb-carousel-item", never, { "interval": { "alias": "interval"; "required": false; }; }, {}, never, ["*"], false, never>;
}
