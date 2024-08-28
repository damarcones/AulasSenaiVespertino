import { QueryList } from '@angular/core';
import { MdbScrollspyLinkDirective } from './scrollspy-link.directive';
import { Observable } from 'rxjs';
import * as i0 from "@angular/core";
export interface MdbScrollspy {
    id: string;
    links: QueryList<MdbScrollspyLinkDirective>;
}
export declare class MdbScrollspyService {
    scrollSpys: MdbScrollspy[];
    private activeSubject;
    active$: Observable<any>;
    addScrollspy(scrollSpy: MdbScrollspy): void;
    removeScrollspy(scrollSpyId: string): void;
    updateActiveState(scrollSpyId: string, activeLinkId: string): void;
    removeActiveState(scrollSpyId: string, activeLinkId: string): void;
    setActiveLink(activeLink: MdbScrollspyLinkDirective | any): void;
    removeActiveLinks(scrollSpyId: string): void;
    static ɵfac: i0.ɵɵFactoryDeclaration<MdbScrollspyService, never>;
    static ɵprov: i0.ɵɵInjectableDeclaration<MdbScrollspyService>;
}
