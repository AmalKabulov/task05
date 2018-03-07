package by.tc.task01.main;

import static by.tc.task01.entity.criteria.SearchCriteria.*;

import by.tc.task01.dao.exception.DAOException;
import by.tc.task01.entity.Appliance;
import by.tc.task01.entity.criteria.Criteria;
import by.tc.task01.entity.criteria.SearchCriteria;
import by.tc.task01.service.ApplianceService;
import by.tc.task01.service.ServiceFactory;

public class Main {

	public static void main(String[] args) throws DAOException {
		Appliance appliance;

		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();


		Criteria<TabletPC> criteriaTabletPC = new Criteria<>();
//		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES, 14);
//		criteriaTabletPC.add(TabletPC.MEMORY_ROM, 8000);
		criteriaTabletPC.add(TabletPC.COLOR, "red");
		appliance = service.find(criteriaTabletPC);
		PrintApplianceInfo.print(appliance);

		Criteria<Laptop> laptopCriteria = new Criteria<>();
		laptopCriteria.add(Laptop.BATTERY_CAPACITY, 1.5);
		laptopCriteria.add(Laptop.CPU, 2.2);
		appliance = service.find(laptopCriteria);
		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria<Oven> criteriaOven = new Criteria<>();
		criteriaOven.add(Oven.CAPACITY, 32);
		criteriaOven.add(Oven.WIDTH, 59.5);
		criteriaOven.add(Oven.HEIGHT, 45.5);
		appliance = service.find(criteriaOven);
		PrintApplianceInfo.print(appliance);

		//////////////////////////////////////////////////////////////////

		Criteria<Refrigerator> criteriaRefrigerator = new Criteria<>();
		criteriaRefrigerator.add(Refrigerator.OVERALL_CAPACITY, 350.5);
		criteriaRefrigerator.add(Refrigerator.FREEZER_CAPACITY, 20);
		appliance = service.find(criteriaRefrigerator);
		PrintApplianceInfo.print(appliance);

		/////////////////////////////////////////////////////////////////




		//////////////////////////////////////////////////////////////////
		Criteria<Speakers> criteriaSpeakers = new Criteria<>();
		criteriaSpeakers.add(Speakers.POWER_CONSUMPTION, 17);
		criteriaSpeakers.add(Speakers.NUMBER_OF_SPEAKERS, 4);
		criteriaSpeakers.add(Speakers.FREQUENCY_RANGE, "2-3.5");
		appliance = service.find(criteriaSpeakers);
		PrintApplianceInfo.print(appliance);

		////////////////////////////////////////////////////////////////


		Criteria<VacuumCleaner> criteriaVacuumCleaner = new Criteria<>();
		criteriaVacuumCleaner.add(VacuumCleaner.WAND_TYPE, "all-in-one");
		criteriaVacuumCleaner.add(VacuumCleaner.BAG_TYPE, "AA-89");
		appliance = service.find(criteriaVacuumCleaner);
		PrintApplianceInfo.print(appliance);

		///////////////////////////////////////////////////////////////


//		criteriaOven = new Criteria<>();
//		criteriaOven.add(Oven.HEIGHT, 200);
//		criteriaOven.add(Oven.DEPTH, 300);
//		appliance = service.find(criteriaOven);
//		PrintApplianceInfo.print(appliance);

	}

}
