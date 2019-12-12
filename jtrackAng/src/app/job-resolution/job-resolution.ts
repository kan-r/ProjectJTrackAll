import { User } from '../user/user';

export class JobResolution {
    jobResolution: string;
    jobResolutionDesc: string;
    active: boolean;
    dateCrt: Date;
    userCrt: string;
    dateMod: Date;
    userMod: string;
    userCrtObj: User;
    userModObj: User;
}
