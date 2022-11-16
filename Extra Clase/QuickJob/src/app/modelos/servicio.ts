import { Subcategoria } from "./subcategoria";

export class Servicio {
    id!: string;
    name!: string;
    description!: string;
    state!: boolean;
    subService!: Subcategoria;
}