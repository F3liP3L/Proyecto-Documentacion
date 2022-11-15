import { Ciudad } from "./ciudad";
import { IdentificationType } from "./identificationType";

export class IdentificationpDocument {

    name!: string;
    surname!: string;
    birthdate!: Date;
    identificationNumber!: string;
    identificationType!: IdentificationType;
    placeOfBirth!: Ciudad;
}