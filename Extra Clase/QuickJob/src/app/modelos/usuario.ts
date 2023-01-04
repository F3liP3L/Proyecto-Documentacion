import { Ciudad } from "./ciudad";
import { IdentificationpDocument } from "./identification-document";

export class Usuario {
    id!: string;
    name!: string;
    lastName!: string;
    identification!: IdentificationpDocument;
    email!: string;
    password!: string;
    residenceCity!: Ciudad
}