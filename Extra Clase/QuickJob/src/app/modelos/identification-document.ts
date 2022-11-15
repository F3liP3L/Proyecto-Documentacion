import { Ciudad } from "./ciudad";
import { IdentificationType } from "./identificationType";

export class IdentificationpDocument {

    name!: string;
    surname!: string;
    birthdate!: Date;
    identificationNumber!: string;
    identificationptye!: IdentificationType;
    placeOfBirth!: Ciudad;
}