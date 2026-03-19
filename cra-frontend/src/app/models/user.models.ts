
export enum RoleEnum {
    ADMIN = 'ADMIN',
    COLLABORATEUR = 'COLLABORATEUR'
}

export enum UserStatusEnum {
    ACTIVE = 'ACTIVE',
    INACTIVE = 'INACTIVE'
}

export enum ContratEnum {
  CDI = 'CDI',
  INDEP = 'INDEP',
  PORTAGE = 'PORTAGE'
}

export enum SenioriteEnum {
  JUNIOR = 'JUNIOR',
  CONFIRME = 'CONFIRME',
  EXPERT = 'EXPERT'
}

export interface UserModel {
    id?: number;
    nom: string;
    prenom: string;
    email: string;
    role: RoleEnum | string;
    statut: UserStatusEnum | string; 
    contrat: ContratEnum | string;
    seriorite: SenioriteEnum | string;
    salaire: number;
    active?: boolean;   
}

