import { Injector } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Snackbar } from './snackbar.model';
import { ConfigSnackbarInt } from './snackbar.config';
import { HttpErrorResponse } from '@angular/common/http';
import * as i0 from "@angular/core";
/**
 * Servicio de snackbar
 *
 * @export
 * @class SnackbarService
 */
export declare class SnackbarService {
    private snackbar;
    private injector;
    /**
     * Constructor del servicio.
     *
     * @param {MatSnackBar} snackbar - Servicio de snackbar.
     * 
     */
    constructor(snackbar: MatSnackBar, injector: Injector);
    /**
     * Permite mostrar un snackbar con los estándares de la uis.
     * @param {Snackbar} data - Objeto con la información del snackbar.
     * @param {number} durationShow - Duración en milisegundos del snackbar.
     * @param {ConfigSnackbarInt} options - Opciones del snackbar.
     */
    show(data: Snackbar, durationShow?: number, options?: ConfigSnackbarInt): void;
    /**
     * Un método para mostrar los errores de backend por defecto.
     *
     * @param {HttpErrorResponse} result - Resultado de la petición.
     * @param {ConfigSnackbarInt} options - Opciones del snackbar.
     */
    showBackError(result: HttpErrorResponse, options?: ConfigSnackbarInt): void;
    /**
     * Función para obtener una traducción.
     *
     * @param key - Key del archivo de traducciones de donde se sacará el mensaje.
     * @param defaultValue - Valor por defecto en caso de no encontrar la key.
     * @returns - Mensaje.
     */
    private customTranslate;
    static ɵfac: i0.ɵɵFactoryDeclaration<SnackbarService, never>;
    static ɵprov: i0.ɵɵInjectableDeclaration<SnackbarService>;
}
